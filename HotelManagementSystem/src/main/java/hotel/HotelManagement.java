/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nyoma
 */

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
