# POSTTEST 1 PBO
# Manajemen-Pengelollaan-Hotel-Samarinda
## Nama   : Nyoman Arini Trirahayu
## NIM    : 2309116002
## Kelas  : A1 Sistem Informasi 2023


### Latar Belakang Pogram
### Latar Belakang Program Manajemen Pengelolaan Hotel

Program *Manajemen Pengelolaan Hotel* ini dikembangkan untuk membantu dalam mengelola data hotel di secara efektif dan efisien. Dalam industri perhotelan, terdapat berbagai tantangan dalam mengelola informasi hotel seperti jumlah kamar, harga, dan lokasi hotel yang perlu dikelola dengan baik agar mempermudah proses administrasi dan pelayanan kepada pelanggan. Dengan adanya sistem ini, operator hotel dapat dengan mudah menambah, melihat, memperbarui, dan menghapus informasi hotel secara terorganisir.

Program ini dirancang menggunakan konsep *Pemrograman Berorientasi Objek (PBO)* untuk memudahkan pengelolaan data hotel, di mana setiap hotel diwakili oleh objek dengan atribut seperti nama, lokasi, jumlah kamar, dan harga. Selain itu, program ini juga memanfaatkan ID unik untuk setiap hotel guna memudahkan identifikasi dan pengelolaan data secara efisien. 

Program ini tidak hanya menyediakan antarmuka yang sederhana untuk administrasi, tetapi juga bisa dikembangkan lebih lanjut untuk berbagai kebutuhan operasional hotel yang lebih kompleks, seperti sistem reservasi kamar dan pelaporan keuangan nantinya.


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
    private int id;
    private String nama;
    private String lokasi;
    private int jumlahKamar;
    private double harga;

    public Hotel(String nama, String lokasi, int jumlahKamar, double harga) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.jumlahKamar = jumlahKamar;
        this.harga = harga;
    }

    // Getter dan Setter untuk ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter dan Setter untuk Nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter untuk Lokasi
    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    // Getter dan Setter untuk Jumlah Kamar
    public int getJumlahKamar() {
        return jumlahKamar;
    }

    public void setJumlahKamar(int jumlahKamar) {
        this.jumlahKamar = jumlahKamar;
    }

    // Getter dan Setter untuk Harga
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}


### Packages manajemen Class HotelManager
package manajemen;

import hotel.Hotel;
import java.util.ArrayList;

public class HotelManager {
    private ArrayList<Hotel> daftarHotel = new ArrayList<>();
    private int nextId = 1; // ID otomatis

    public void tambahHotel(Hotel hotel) {
        hotel.setId(nextId++);
        daftarHotel.add(hotel);
    }

    public void tampilkanSemuaHotel() {
        for (Hotel hotel : daftarHotel) {
            System.out.printf("%-5d %-30s %-20s %-15d %-10.2f\n", hotel.getId(), hotel.getNama(), hotel.getLokasi(), hotel.getJumlahKamar(), hotel.getHarga());
        }
    }

    public void hapusHotel(int id) {
        for (int i = 0; i < daftarHotel.size(); i++) {
            if (daftarHotel.get(i).getId() == id) {
                daftarHotel.remove(i);
                return;
            }
        }
        System.out.println("Hotel dengan ID " + id + " tidak ditemukan.");
    }

    public void updateHotel(int id, String nama, String lokasi, int jumlahKamar, double harga) {
        for (Hotel hotel : daftarHotel) {
            if (hotel.getId() == id) {
                hotel.setNama(nama);
                hotel.setLokasi(lokasi);
                hotel.setJumlahKamar(jumlahKamar);
                hotel.setHarga(harga);
                return;
            }
        }
        System.out.println("Hotel dengan ID " + id + " tidak ditemukan.");
    }

    public int getTotalHotel() {
        return daftarHotel.size();
    }
}


### Penjelasan Source
Berikut penjelasan detail dari program **Manajemen Pengelolaan Hotel** yang Anda buat, mirip dengan gaya penjelasan yang Anda minta:

### **ManajemenHotel.java**
Pada class **ManajemenHotel.java**, terdapat beberapa method yang digunakan untuk mengatur program, yaitu:

1. **tambahHotel()**
2. **tampilkanSemuaHotel()**
3. **hapusHotel()**
4. **updateHotel()**

Masing-masing method tersebut memiliki fungsi yang berbeda, seperti:

- **tambahHotel()** digunakan untuk menambahkan hotel baru dengan memasukkan nama, lokasi, jumlah kamar, dan harga hotel.
- **tampilkanSemuaHotel()** digunakan untuk menampilkan semua hotel yang terdaftar dalam sistem.
- **hapusHotel()** digunakan untuk menghapus hotel yang ada dengan memasukkan ID hotel yang ingin dihapus.
- **updateHotel()** digunakan untuk memperbarui data hotel yang ada dengan memasukkan ID hotel yang ingin diperbarui, nama baru, lokasi baru, jumlah kamar baru, dan harga baru.

Program ini juga memiliki method **main()**, yang digunakan untuk menjalankan program dan menyediakan antarmuka menu interaktif untuk pengguna (admin). Admin dapat memilih opsi untuk menambahkan, menampilkan, menghapus, atau memperbarui hotel.

### **HotelManager.java**
Pada class **HotelManager.java**, terdapat beberapa method yang digunakan untuk mengatur data hotel yang disimpan dalam sebuah **ArrayList**. Method-method ini adalah:

1. **tambahHotel()**
2. **tampilkanSemuaHotel()**
3. **hapusHotel()**
4. **updateHotel()**

Masing-masing method memiliki fungsinya sendiri:

- **tambahHotel()** digunakan untuk menambahkan hotel baru ke dalam **ArrayList** yang berisi daftar hotel. Hotel yang baru ditambahkan akan otomatis mendapatkan **ID** berdasarkan urutan penambahan.
- **tampilkanSemuaHotel()** digunakan untuk menampilkan daftar lengkap semua hotel beserta detail informasi seperti ID, nama, lokasi, jumlah kamar, dan harga, dalam format tabel.
- **hapusHotel()** digunakan untuk menghapus hotel dari daftar berdasarkan **ID** yang diberikan.
- **updateHotel()** digunakan untuk memperbarui informasi hotel yang ada dalam daftar dengan **ID** yang sesuai.

Class ini mengelola **ArrayList** yang menyimpan data hotel, dan setiap hotel diidentifikasi menggunakan **ID** unik yang otomatis bertambah setiap kali hotel baru ditambahkan.

### **Hotel.java**
Pada class **Hotel.java**, terdapat beberapa method yang digunakan untuk mengatur atribut hotel, seperti:

1. **getId()**
2. **getNama()**
3. **getLokasi()**
4. **getJumlahKamar()**
5. **getHarga()**

Masing-masing method memiliki fungsinya sendiri:

- **getId()** digunakan untuk mendapatkan ID hotel.
- **getNama()** digunakan untuk mendapatkan nama hotel.
- **getLokasi()** digunakan untuk mendapatkan lokasi hotel.
- **getJumlahKamar()** digunakan untuk mendapatkan jumlah kamar hotel.
- **getHarga()** digunakan untuk mendapatkan harga hotel.

Class **Hotel.java** juga memiliki setter untuk memperbarui nilai dari atribut-atribut tersebut. Setiap objek hotel memiliki atribut **nama**, **lokasi**, **jumlah kamar**, dan **harga** yang bersifat private, sehingga tidak bisa diakses langsung dari luar class. Melalui setter dan getter, data ini dapat diakses dan diubah secara aman.

### **Hubungan Antara Class**
- **ManajemenHotel.java** bertindak sebagai antarmuka utama bagi pengguna (admin) untuk berinteraksi dengan sistem. Di dalamnya, terdapat menu yang memungkinkan admin untuk menambahkan, menampilkan, menghapus, atau memperbarui hotel. Semua operasi ini dikelola oleh **HotelManager.java**.
  
- **HotelManager.java** memiliki peran dalam menyimpan dan mengelola daftar hotel. Operasi penambahan, penghapusan, dan pembaruan hotel dilakukan dengan memodifikasi **ArrayList** hotel yang bersifat private di class ini. **ManajemenHotel.java** menggunakan method dari **HotelManager.java** untuk melakukan berbagai operasi pada data hotel.

- **Hotel.java** berfungsi sebagai class yang mendefinisikan struktur data dari sebuah hotel. Class ini memiliki getter dan setter untuk mengakses dan memanipulasi atribut hotel seperti nama, lokasi, jumlah kamar, dan harga.

Dengan demikian, **ManajemenHotel.java**, **HotelManager.java**, dan **Hotel.java** saling terhubung untuk membentuk sistem pengelolaan hotel yang efisien.


### Penjelasan Output
