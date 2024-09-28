# PBO_Manajemen-Pengelollaan-Hotel-Samarinda
## Nama   : Nyoman Arini Trirahayu
## NIM    : 2309116002
## Kelas  : A1 Sistem Informasi 2023

### Source Code
### Packages com.mycompany Class ManajemenHotel.java
package com.mycompany.manajemenhotel;

import manajemen.HotelManager;
import hotel.Hotel;
import java.util.Scanner;

public class ManajemenHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelManager hotelManager = new HotelManager();

        // Menambahkan beberapa hotel secara default
        hotelManager.tambahHotel(new Hotel("Hotel Grand Surya", "Samarinda", 180, 500000));
        hotelManager.tambahHotel(new Hotel("Hotel Mercure Samarinda", "Samarinda", 220, 600000));
        hotelManager.tambahHotel(new Hotel("Hotel Aston Samarinda", "Samarinda", 200, 550000));
        hotelManager.tambahHotel(new Hotel("Hotel Ibis Samarinda", "Samarinda", 150, 450000));
        hotelManager.tambahHotel(new Hotel("Hotel Fave Samarinda", "Samarinda", 130, 400000));
        hotelManager.tambahHotel(new Hotel("Hotel Royal Samarinda", "Samarinda", 160, 470000));
        hotelManager.tambahHotel(new Hotel("Hotel Horison Samarinda", "Samarinda", 170, 490000));
        hotelManager.tambahHotel(new Hotel("Hotel Atria Samarinda", "Samarinda", 140, 460000));
        hotelManager.tambahHotel(new Hotel("Hotel Santika Samarinda", "Samarinda", 190, 520000));

        // Sistem Login Admin
        String username = "admin";
        String password = "admin123"; // Anda bisa mengubah ini sesuai kebutuhan

        boolean loginBerhasil = false;
        while (!loginBerhasil) {
            System.out.print("Masukkan username: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String inputPassword = scanner.nextLine();

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                loginBerhasil = true;
                System.out.println("Login berhasil! Selamat datang, Admin.");
            } else {
                System.out.println("Login gagal! Username atau password salah. Coba lagi.");
                System.out.print("Apakah Anda ingin keluar? (ya/tidak): ");
                String pilihanKeluar = scanner.nextLine();
                if (pilihanKeluar.equalsIgnoreCase("ya")) {
                    System.out.println("Keluar dari sistem.");
                    scanner.close();
                    return; // Keluar dari program
                }
            }
        }

        // Menu Admin setelah login berhasil
        boolean keluar = false;
        while (!keluar) {
            // Menu untuk admin
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Tambah Hotel");
            System.out.println("2. Tampilkan Semua Hotel");
            System.out.println("3. Hapus Hotel");
            System.out.println("4. Tampilkan Total Hotel");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengatasi masalah nextInt()

            switch (pilihan) {
                case 1:
                    // Tambah hotel
                    System.out.print("Masukkan nama hotel: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan lokasi hotel: ");
                    String lokasi = scanner.nextLine();
                    System.out.print("Masukkan jumlah kamar: ");
                    int jumlahKamar = scanner.nextInt();
                    System.out.print("Masukkan harga: ");
                    double harga = scanner.nextDouble();
                    scanner.nextLine(); // Mengatasi masalah nextDouble()

                    Hotel hotel = new Hotel(nama, lokasi, jumlahKamar, harga);
                    hotelManager.tambahHotel(hotel);
                    break;

                case 2:
                    // Tampilkan semua hotel
                    hotelManager.tampilkanSemuaHotel();
                    break;

                case 3:
                    // Hapus hotel
                    System.out.print("Masukkan nama hotel yang akan dihapus: ");
                    String namaHapus = scanner.nextLine();
                    hotelManager.hapusHotel(namaHapus);
                    break;

                case 4:
                    // Tampilkan total hotel
                    System.out.println("Total hotel saat ini: " + hotelManager.getTotalHotel());
                    break;

                case 5:
                    // Keluar
                    keluar = true;
                    System.out.println("Keluar dari sistem.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}


### Pakages hotel Class Hotel.java
package hotel;

public class Hotel {
    private String nama;
    private String lokasi;
    private int jumlahKamar;
    private double harga;
    private static int totalHotel = 0;

    public Hotel(String nama, String lokasi, int jumlahKamar, double harga) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.jumlahKamar = jumlahKamar;
        this.harga = harga;
        totalHotel++;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getJumlahKamar() {
        return jumlahKamar;
    }

    public double getHarga() {
        return harga;
    }

    public static int getTotalHotel() {
        return totalHotel;
    }
}

### Packages manajemen Class HotelManager
package manajemen;

import hotel.Hotel;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private List<Hotel> hotels;

    public HotelManager() {
        hotels = new ArrayList<>();
    }

    public void tambahHotel(Hotel hotel) {
        hotels.add(hotel);
        // Menghapus output saat hotel ditambahkan
    }

    public void tampilkanSemuaHotel() {
        if (hotels.isEmpty()) {
            System.out.println("Tidak ada hotel yang tersedia.");
            return;
        }
        System.out.println("\n=== Daftar Hotel ===");
        System.out.printf("%-30s %-20s %-15s %-10s%n", "Nama", "Lokasi", "Jumlah Kamar", "Harga");
        System.out.println("--------------------------------------------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.printf("%-30s %-20s %-15d %-10.2f%n", hotel.getNama(), hotel.getLokasi(),
                    hotel.getJumlahKamar(), hotel.getHarga());
        }
    }

    public void hapusHotel(String nama) {
        for (Hotel hotel : hotels) {
            if (hotel.getNama().equalsIgnoreCase(nama)) {
                hotels.remove(hotel);
                return;
            }
        }
        System.out.println("Hotel " + nama + " tidak ditemukan.");
    }

    public int getTotalHotel() {
        return hotels.size();
    }
}

