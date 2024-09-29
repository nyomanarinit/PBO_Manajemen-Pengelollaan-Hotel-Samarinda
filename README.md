# POSTTEST 1 PBO
# Manajemen-Pengelolaan-Hotel
## Nama   : Nyoman Arini Trirahayu
## NIM    : 2309116002
## Kelas  : A1 Sistem Informasi 2023


### Latar Belakang Pogram
### Latar Belakang Program Manajemen Pengelolaan Hotel

Berikut adalah latar belakang yang menjelaskan secara singkat mengenai program manajemen hotel:

---

## Latar Belakang Program Manajemen Hotel

Program Manajemen Hotel ini dirancang untuk membantu pengelolaan kamar dan reservasi di salah satu hotel di Samarinda. Dalam dunia perhotelan, pengelolaan data kamar dan reservasi sangat penting untuk memastikan efisiensi operasional dan kepuasan tamu. Program ini bertujuan untuk memberikan solusi yang sederhana namun efektif bagi staf hotel dalam mengelola informasi kamar dan reservasi dengan lebih mudah dan terstruktur.

### Fitur Utama

1. **Manajemen Kamar**: Program ini memungkinkan pengguna untuk melihat, menambah, memperbarui, dan menghapus data kamar hotel. Setiap kamar dilengkapi dengan informasi seperti nomor kamar, tipe, harga, dan status ketersediaan. Dengan fitur ini, staf hotel dapat dengan cepat memantau kondisi kamar yang tersedia dan membuat keputusan yang tepat terkait pengelolaan kamar.

2. **Manajemen Reservasi**: Program ini juga memungkinkan staf untuk mengelola reservasi tamu dengan efisien. Pengguna dapat melihat daftar reservasi yang ada, menambahkan reservasi baru, serta memperbarui atau membatalkan reservasi sesuai kebutuhan. Dengan adanya data reservasi default, pengguna dapat dengan mudah melihat dan mengelola informasi reservasi yang sudah ada tanpa harus mulai dari awal.

### Teknologi yang Digunakan

Program ini dibangun menggunakan bahasa pemrograman Java dengan penerapan konsep Object-Oriented Programming (OOP). Struktur program dibagi menjadi beberapa kelas, yang masing-masing memiliki tanggung jawab tertentu, seperti manajemen kamar dan manajemen reservasi. Program ini juga menggunakan ArrayList untuk menyimpan data kamar dan reservasi, serta Scanner untuk berinteraksi dengan pengguna.

### Tujuan Program

Tujuan utama dari program ini adalah untuk menyediakan sistem yang user-friendly bagi staf hotel dalam mengelola kamar dan reservasi. Dengan memanfaatkan program ini, diharapkan proses pengelolaan data dapat dilakukan dengan lebih cepat, akurat, dan efisien, sehingga meningkatkan pengalaman tamu dan operasional hotel secara keseluruhan.

### Source Code
### Packages hotel Class HotelManagement.java

package hotel;

import java.util.ArrayList;

public class HotelManagement {
    private ArrayList<Room> rooms;

    public HotelManagement() {
        rooms = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 500000, true));
        rooms.add(new Room(102, "Double", 800000, true));
        rooms.add(new Room(103, "Suite", 1500000, false));
        rooms.add(new Room(104, "Single", 500000, true));
        rooms.add(new Room(105, "Double", 800000, false));
        rooms.add(new Room(201, "VIP", 2500000, true));
        rooms.add(new Room(202, "VIP", 2500000, false));
        rooms.add(new Room(203, "Suite", 1600000, true));
        rooms.add(new Room(204, "Single", 550000, true));
        rooms.add(new Room(205, "Double", 850000, false));
    }

    // Menampilkan semua kamar
    public void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("Tidak ada kamar saat ini.");
            return;
        }
        System.out.println("--- Daftar Kamar ---");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    // Menampilkan kamar yang tersedia
    public void displayAvailableRooms() {
        boolean hasAvailableRooms = false;
        System.out.println("--- Kamar Tersedia ---");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
                hasAvailableRooms = true;
            }
        }
        if (!hasAvailableRooms) {
            System.out.println("Tidak ada kamar yang tersedia.");
        }
    }

    // Menambahkan kamar
    public void addRoom(int roomNumber, String roomType, double roomPrice, boolean isAvailable) {
        rooms.add(new Room(roomNumber, roomType, roomPrice, isAvailable));
        System.out.println("Kamar berhasil ditambahkan.");
    }

    // Memperbarui kamar
    public void updateRoom(int roomNumber, String roomType, double roomPrice, boolean isAvailable) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.setRoomType(roomType);
                room.setRoomPrice(roomPrice);
                room.setAvailable(isAvailable);
                System.out.println("Kamar berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Kamar tidak ditemukan.");
    }

    // Menghapus kamar
    public void deleteRoom(int roomNumber) {
        boolean removed = rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
        if (removed) {
            System.out.println("Kamar berhasil dihapus.");
        } else {
            System.out.println("Kamar tidak ditemukan.");
        }
    }

    // Memeriksa ketersediaan kamar
    public boolean isRoomAvailable(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room.isAvailable();
            }
        }
        return false; // Jika kamar tidak ditemukan
    }
}



### Packages hotel Class Room.java

package hotel;
public class Room {
    private int roomNumber;
    private String roomType;
    private double roomPrice;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double roomPrice, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("Nomor Kamar: %d | Tipe Kamar: %s | Harga: %.2f | Tersedia: %s", 
                roomNumber, roomType, roomPrice, isAvailable ? "Ya" : "Tidak");
    }
}

### Packages reservation Class Reservation.java

package reservation;

public class Reservation {
    private String guestName;
    private int roomNumber;
    private String reservationDate;

    public Reservation(String guestName, int roomNumber, String reservationDate) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.reservationDate = reservationDate;
    }

    // Getter dan Setter
    public String getGuestName() {
        return guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Nama Tamu: " + guestName + ", Nomor Kamar: " + roomNumber + ", Tanggal Reservasi: " + reservationDate;
    }
}

### Packages reservation Class ReservationManagement.java

package reservation;

import hotel.HotelManagement;
import java.util.ArrayList;
import java.util.List;

public class ReservationManagement {
    private List<Reservation> reservations;

    public ReservationManagement() {
        this.reservations = new ArrayList<>();
        // Menambahkan data reservasi default
        reservations.add(new Reservation("Alice", 101, "2024-09-29"));
        reservations.add(new Reservation("Bob", 102, "2024-09-30"));
        reservations.add(new Reservation("Charlie", 103, "2024-10-01"));
        reservations.add(new Reservation("Diana", 104, "2024-10-02"));
        reservations.add(new Reservation("Eve", 105, "2024-10-03"));
    }

    public ReservationManagement(HotelManagement hotelManagement) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Menampilkan semua reservasi
    public void displayReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Tidak ada reservasi saat ini.");
            return;
        }
        System.out.println("--- Daftar Reservasi ---");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    // Menambah reservasi baru
    public void addReservation(String guestName, int roomNumber, String reservationDate) {
        reservations.add(new Reservation(guestName, roomNumber, reservationDate));
        System.out.println("Reservasi berhasil ditambahkan.");
    }

    // Membatalkan reservasi berdasarkan nomor kamar
    public void cancelReservation(int roomNumber) {
        reservations.removeIf(reservation -> reservation.getRoomNumber() == roomNumber);
        System.out.println("Reservasi untuk kamar " + roomNumber + " berhasil dibatalkan.");
    }

    // Memperbarui reservasi
    public void updateReservation(int roomNumber, String guestName, String reservationDate) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomNumber() == roomNumber) {
                reservation.setGuestName(guestName);
                reservation.setReservationDate(reservationDate);
                System.out.println("Reservasi untuk kamar " + roomNumber + " berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Reservasi untuk kamar " + roomNumber + " tidak ditemukan.");
    }
}

### Penjelasan Source Code

### 1. HotelManagementSystem.java
Pada class HotelManagementSystem.java, terdapat metode utama yang menjalankan program, yaitu main(). Metode ini melakukan beberapa hal penting:

- Penggunaan Scanner: Menggunakan objek Scanner untuk mengambil input dari pengguna.
- Pemilihan Menu: Menampilkan menu utama untuk manajemen kamar hotel dan reservasi. Pengguna dapat memilih antara mengelola kamar atau reservasi.
- Pemanggilan Metode: Berdasarkan pilihan pengguna, class ini memanggil metode lain untuk mengelola kamar atau reservasi.

### 2. HotelManagement.java
Class HotelManagement.java bertanggung jawab untuk mengelola data kamar hotel. Beberapa metode dalam class ini adalah:

- initializeRooms(): Menginisialisasi kamar dengan data default. Menambahkan beberapa objek Room ke dalam list rooms.
- displayRooms(): Menampilkan semua kamar yang ada di hotel.
- displayAvailableRooms(): Menampilkan hanya kamar yang tersedia. Metode ini memeriksa status ketersediaan setiap kamar.
- addRoom(): Menambahkan kamar baru ke dalam daftar kamar. 
- updateRoom(): Memperbarui informasi kamar yang sudah ada berdasarkan nomor kamar.
- deleteRoom(): Menghapus kamar dari daftar berdasarkan nomor kamar.
- isRoomAvailable(): Memeriksa apakah suatu kamar tersedia.

### 3. Room.java
Class Room.java mendeskripsikan struktur kamar hotel. Beberapa metode dan atribut yang ada di dalamnya adalah:

- Properties: Mencakup atribut seperti roomNumber, roomType, roomPrice, dan isAvailable untuk menyimpan informasi tentang kamar.
- Constructor: Menginisialisasi objek Room dengan nomor kamar, tipe, harga, dan status ketersediaan.
- Getter dan Setter: Menyediakan metode untuk mendapatkan dan mengubah nilai atribut Room, seperti getRoomNumber(), setRoomType(), dan setAvailable().

### 4. ReservationManagement.java
Class ReservationManagement.java berfungsi untuk mengelola reservasi kamar. Beberapa metode dalam class ini adalah:

- displayReservations(): Menampilkan semua reservasi yang telah dibuat.
- addReservation(): Menambahkan reservasi baru dengan nama tamu, nomor kamar, dan tanggal reservasi.
- cancelReservation(): Menghapus reservasi berdasarkan nomor kamar.
- updateReservation(): Memperbarui informasi reservasi yang sudah ada.

### Hubungan Antara Class
- HotelManagementSystem adalah class utama yang menjalankan aplikasi. Ia berinteraksi dengan class HotelManagement untuk mengelola kamar dan ReservationManagement untuk mengelola reservasi.
- HotelManagement dan ReservationManagement saling terhubung melalui proses validasi status kamar. ReservationManagement perlu memeriksa status ketersediaan kamar melalui metode isRoomAvailable() di HotelManagement.
- Room adalah model data yang digunakan oleh class HotelManagement untuk menyimpan dan mengelola informasi kamar.

### Penjelasan Output
1. Masuk Kemenu Utama

   
    ![Cuplikan layar 2024-09-29 113641](https://github.com/user-attachments/assets/eff323ed-6aad-4d06-9a4b-5a41224a91b1)


2. Masuk Kemenu Manajemen Hotel
   
   ![Cuplikan layar 2024-09-29 090034](https://github.com/user-attachments/assets/6e57935d-ce1d-4bb4-a037-8954ec41806b)


3. Menu  Manajemen Hotel Lihat Kamar

   ![image](https://github.com/user-attachments/assets/427368fe-cc4a-4087-8cf2-28c7e101b14c)

4. Menu  Manajemen Hotel Tambah Kamar

    ![Cuplikan layar 2024-09-29 113750](https://github.com/user-attachments/assets/7a5aca59-0816-4827-92ab-fbe4f6df17a2)


    ![Cuplikan layar 2024-09-29 113804](https://github.com/user-attachments/assets/b8eb621e-78f6-469d-a041-436545740faf)


5. Menu  Manajemen Hotel Ubah Kamar

    ![Cuplikan layar 2024-09-29 113852](https://github.com/user-attachments/assets/78ab60a8-30cf-4cd0-9961-815940651d2f)


   ![Cuplikan layar 2024-09-29 113900](https://github.com/user-attachments/assets/8f79ef96-38a3-458b-9b31-3d95642e52c0)


6. Menu  Manajemen Hotel Hapus Kamar

   ![Cuplikan layar 2024-09-29 113922](https://github.com/user-attachments/assets/bc5be84f-abad-47d8-8d8d-fee3517f3ba0)


7. Menu  Manajemen Hotel Kmebali Kemenu Utama

    ![Cuplikan layar 2024-09-29 113935](https://github.com/user-attachments/assets/3c199b07-7da8-44f9-8ff2-26c01fd96a62)


8. Masuk Kemenu Manajemen Reservasi

   ![Cuplikan layar 2024-09-29 113942](https://github.com/user-attachments/assets/60665e4d-47cd-4d3b-8b42-6b93d5395d12)

9. Menu Manajemen Reservasi Lihat Reservasi
    
    ![Cuplikan layar 2024-09-29 113953](https://github.com/user-attachments/assets/6773630e-a8fe-439f-97aa-6ed96df8d533)

10. Menu Manajemen Reservasi Tambah Reservasi

    ![Cuplikan layar 2024-09-29 114030](https://github.com/user-attachments/assets/38d7baca-61bd-4edc-a3e8-e20e2606de3d)


    ![Cuplikan layar 2024-09-29 114041](https://github.com/user-attachments/assets/0b2e21f0-7a92-4f6c-9a03-30b0937d964f)


11.  Menu Manajemen Reservasi Ubah Reservasi


     [Cuplikan layar 2024-09-29 115930](https://github.com/user-attachments/assets/a86d4526-e74f-44f1-8921-6d74d5740d51)



14. Menu Manajemen Reservasi Hapus Reservasi

    ![Cuplikan layar 2024-09-29 114124](https://github.com/user-attachments/assets/e645f734-c7ee-4d28-86bc-1c7593c0d93d)


    ![Cuplikan layar 2024-09-29 114130](https://github.com/user-attachments/assets/49753150-5ddb-4d77-9c89-cbc71e8751e4)


15. Menu Manajemen Reservasi Kembali Kemenu Utama

    ![Cuplikan layar 2024-09-29 114206](https://github.com/user-attachments/assets/b7d9e112-ded5-443f-a11f-f0d9a6a64564)


16. Tampilan AKhir Program

    ![Cuplikan layar 2024-09-29 114216](https://github.com/user-attachments/assets/e04107e5-4a7f-41ba-be4b-d94175a9033f)


    

    
