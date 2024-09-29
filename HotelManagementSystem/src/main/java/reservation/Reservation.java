/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservation;

/**
 *
 * @author nyoma
 */

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
