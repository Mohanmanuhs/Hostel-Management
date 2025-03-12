package com.example.hostelManagement.controllers.hostel;


import com.example.hostelManagement.repository.hostel.HostelRepo;
import com.example.hostelManagement.service.hostel.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostelController {

    @Autowired
    private HostelService hostelService;

}