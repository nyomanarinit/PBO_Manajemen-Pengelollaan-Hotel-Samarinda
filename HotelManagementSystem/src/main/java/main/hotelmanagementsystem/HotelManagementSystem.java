/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main.hotelmanagementsystem;

/**
 *
 * @author nyoma1
 * 
 */
import hotel.HotelManagement;
import reservation.ReservationManagement;

import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelManagement hotelManagement = new HotelManagement(); // Deklarasi variabel hotelManagement
        ReservationManagement reservationManagement = new ReservationManagement(); // Pastikan ini juga ada

        while (true) {
            System.out.println("\n--- Sistem Manajemen Hotel ---");
            System.out.println("1. Manajemen Kamar Hotel");
            System.out.println("2. Manajemen Reservasi");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    manageRooms(scanner, hotelManagement);
                    break;

                case 2:
                    manageReservations(scanner, hotelManagement, reservationManagement); // Pass hotelManagement ke manageReservations
                    break;

                case 3:
                    System.out.println("Keluar...");
                    return;

                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }
        }
    }

    // Metode untuk mengelola kamar
    private static void manageRooms(Scanner scanner, HotelManagement hotelManagement) {
        while (true) {
            System.out.println("\n--- Manajemen Kamar ---");
            System.out.println("1. Lihat Kamar");
            System.out.println("2. Tambah Kamar");
            System.out.println("3. Ubah Kamar");
            System.out.println("4. Hapus Kamar");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            int roomChoice = scanner.nextInt();

            switch (roomChoice) {
                case 1:
                    hotelManagement.displayRooms();
                    break;

                case 2:
                    System.out.print("Masukkan Nomor Kamar: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Masukkan Tipe Kamar: ");
                    scanner.nextLine();  // consume newline
                    String roomType = scanner.nextLine();
                    System.out.print("Masukkan Harga Kamar: ");
                    double roomPrice = scanner.nextDouble();
                    System.out.print("Apakah Kamar Tersedia (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    hotelManagement.addRoom(roomNumber, roomType, roomPrice, isAvailable);
                    break;

                case 3:
                    System.out.print("Masukkan Nomor Kamar untuk Diperbarui: ");
                    int updateRoomNumber = scanner.nextInt();
                    System.out.print("Masukkan Tipe Kamar: ");
                    scanner.nextLine();  // consume newline
                    String updateRoomType = scanner.nextLine();
                    System.out.print("Masukkan Harga Kamar: ");
                    double updateRoomPrice = scanner.nextDouble();
                    System.out.print("Apakah Kamar Tersedia (true/false): ");
                    boolean updateIsAvailable = scanner.nextBoolean();
                    hotelManagement.updateRoom(updateRoomNumber, updateRoomType, updateRoomPrice, updateIsAvailable);
                    break;

                case 4:
                    System.out.print("Masukkan Nomor Kamar untuk Dihapus: ");
                    int deleteRoomNumber = scanner.nextInt();
                    hotelManagement.deleteRoom(deleteRoomNumber);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }
        }
    }

    // Metode untuk mengelola reservasi
    private static void manageReservations(Scanner scanner, HotelManagement hotelManagement, ReservationManagement reservationManagement) {
        while (true) {
            System.out.println("\n--- Manajemen Reservasi ---");
            System.out.println("1. Lihat Reservasi");
            System.out.println("2. Tambah Reservasi");
            System.out.println("3. Batalkan Reservasi");
            System.out.println("4. Ubah Reservasi");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            int reservationChoice = scanner.nextInt();

            switch (reservationChoice) {
                case 1:
                    reservationManagement.displayReservations();
                    break;

                case 2:
                    // Menampilkan kamar yang tersedia
                    hotelManagement.displayAvailableRooms();

                    System.out.print("Masukkan Nama Tamu: ");
                    scanner.nextLine();  // consume newline
                    String guestName = scanner.nextLine();
                    
                    // Minta pengguna untuk memilih kamar yang tersedia
                    System.out.print("Masukkan Nomor Kamar yang Tersedia: ");
                    int roomNumber = scanner.nextInt();
                    
                    // Cek ketersediaan kamar
                    if (!hotelManagement.isRoomAvailable(roomNumber)) {
                        System.out.println("Kamar tidak tersedia. Silakan pilih kamar lain.");
                    } else {
                        System.out.print("Masukkan Tanggal Reservasi (YYYY-MM-DD): ");
                        String reservationDate = scanner.next();
                        reservationManagement.addReservation(guestName, roomNumber, reservationDate);
                    }
                    break;

                case 3:
                    System.out.print("Masukkan Nomor Kamar untuk Dibatalkan: ");
                    int cancelRoomNumber = scanner.nextInt();
                    reservationManagement.cancelReservation(cancelRoomNumber);
                    break;

                case 4:
                    System.out.print("Masukkan Nomor Kamar untuk Diubah: ");
                    int updateRoomNumber = scanner.nextInt();
                    System.out.print("Masukkan Nama Tamu Baru: ");
                    scanner.nextLine();  // consume newline
                    String newGuestName = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Reservasi Baru (YYYY-MM-DD): ");
                    String newReservationDate = scanner.next();
                    reservationManagement.updateReservation(updateRoomNumber, newGuestName, newReservationDate);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }
        }
    }
}
