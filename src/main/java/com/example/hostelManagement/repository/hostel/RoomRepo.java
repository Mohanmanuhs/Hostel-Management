package com.example.hostelManagement.repository.hostel;

import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.hostel.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {

    List<Room> findByHostelAndFloorNoOrderByRoomNoAsc(Hostel hostel, Integer floorNo);

}