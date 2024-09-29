/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservation;

/**
 *
 * @author nyoma
 */

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
