/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author nyoma
 */

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

