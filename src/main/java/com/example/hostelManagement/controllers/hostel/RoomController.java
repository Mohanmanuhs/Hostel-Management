package com.example.hostelManagement.controllers.hostel;


import com.example.hostelManagement.repository.hostel.RoomRepo;
import com.example.hostelManagement.service.hostel.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomController {

    @Autowired
    private RoomService roomService;

}