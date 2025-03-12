package com.example.hostelManagement.service.hostel;


import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.hostel.Room;
import com.example.hostelManagement.repository.hostel.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    public void createRoomsForFixedSize(int floorNo, int totalRooms, int startRoomNo, Hostel hostel, int totalSeatsInEachRoom) {
        int i = startRoomNo;
        while (i <= startRoomNo + totalRooms) {
            Room room = new Room();
            room.setRoom_no(i);
            room.setHostel(hostel);
            room.setFloor_no(floorNo);
            room.setTotal_seats(totalSeatsInEachRoom);
            room.setEmpty_seats(totalSeatsInEachRoom);
            roomRepo.save(room);
            i++;
        }
    }

    public void createRoom(int floorNo, int roomNo, Hostel hostel, int totalSeatsInRoom) {
        Room room = new Room();
        room.setRoom_no(roomNo);
        room.setHostel(hostel);
        room.setFloor_no(floorNo);
        room.setTotal_seats(totalSeatsInRoom);
        room.setEmpty_seats(totalSeatsInRoom);
        roomRepo.save(room);
    }

    public Optional<Room> getRoom(int roomId) {
        return roomRepo.findById(roomId);
    }

    public


}