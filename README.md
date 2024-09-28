# POSTTEST 1 PBO
# Manajemen-Pengelollaan-Hotel-Samarinda
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
        
        // Menambahkan beberapa hotel secara default dengan nama jalan
        hotelManager.tambahHotel(new Hotel("Hotel Grand Surya", "Jalan Pahlawan", 180, 500000));
        hotelManager.tambahHotel(new Hotel("Hotel Mercure", "Jalan Sejahtera", 220, 600000));
        hotelManager.tambahHotel(new Hotel("Hotel Aston", "Jalan Damai", 200, 550000));
        hotelManager.tambahHotel(new Hotel("Hotel Ibis", "Jalan Kebangkitan", 150, 450000));
        hotelManager.tambahHotel(new Hotel("Hotel Fave", "Jalan Cinta", 130, 400000));
        hotelManager.tambahHotel(new Hotel("Hotel Royal", "Jalan Maju", 160, 470000));
        hotelManager.tambahHotel(new Hotel("Hotel Horison", "Jalan Harapan", 170, 490000));
        hotelManager.tambahHotel(new Hotel("Hotel Atria", "Jalan Bahagia", 140, 460000));
        hotelManager.tambahHotel(new Hotel("Hotel Santika", "Jalan Sukses", 190, 520000));

        // Menu Admin
        boolean keluar = false;
        while (!keluar) {
            // Menu untuk admin
            System.out.println("\n======== Menu  ========");
            System.out.println("1. Tambah Hotel");
            System.out.println("2. Tampilkan Semua Hotel");
            System.out.println("3. Hapus Hotel");
            System.out.println("4. Update Hotel");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi admin: ");
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
                    // Menampilkan pesan sukses
                    System.out.println("" + nama + " berhasil ditambahkan.");
                    break;

                case 2:
                    // Tampilkan semua hotel dalam format tabel
                    System.out.printf("%-5s %-30s %-20s %-15s %-10s\n", "ID", "Nama Hotel", "Lokasi", "Jumlah Kamar", "Harga");
                    System.out.println("----------------------------------------------------------------------------------------");
                    hotelManager.tampilkanSemuaHotel();
                    System.out.println("----------------------------------------------------------------------------------------");
                    // Tampilkan total hotel
                    System.out.println("TOTAL HOTEL SAAT INI: " + hotelManager.getTotalHotel());
                    break;

                case 3:
                    // Hapus hotel
                    System.out.print("Masukkan ID hotel yang akan dihapus: ");
                    int idHapus = scanner.nextInt();
                    hotelManager.hapusHotel(idHapus);
                    System.out.println("Hotel dengan ID " + idHapus + " berhasil dihapus.");
                    break;

                case 4:
                    // Update hotel
                    System.out.print("Masukkan ID hotel yang akan diupdate: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine(); // Mengatasi masalah nextInt()
                    System.out.print("Masukkan nama hotel baru: ");
                    String namaUpdate = scanner.nextLine();
                    System.out.print("Masukkan lokasi hotel baru: ");
                    String lokasiUpdate = scanner.nextLine();
                    System.out.print("Masukkan jumlah kamar baru: ");
                    int jumlahKamarUpdate = scanner.nextInt();
                    System.out.print("Masukkan harga baru: ");
                    double hargaUpdate = scanner.nextDouble();
                    scanner.nextLine(); // Mengatasi masalah nextDouble()

                    hotelManager.updateHotel(idUpdate, namaUpdate, lokasiUpdate, jumlahKamarUpdate, hargaUpdate);
                    System.out.println("Hotel dengan ID " + idUpdate + " berhasil diupdate.");
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

