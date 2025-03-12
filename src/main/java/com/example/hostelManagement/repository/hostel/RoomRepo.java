package com.example.hostelManagement.repository.hostel;

import com.example.hostelManagement.models.hostel.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
}
