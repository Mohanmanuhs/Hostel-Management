package com.example.hostelManagement.controllers;


import com.example.hostelManagement.dto.ApplicationDto;
import com.example.hostelManagement.dto.ChangeApplicationDto;
import com.example.hostelManagement.dto.RoomFixedDto;
import com.example.hostelManagement.models.Application;
import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.user.User;
import com.example.hostelManagement.repository.ApplicationRepo;
import com.example.hostelManagement.service.ApplicationService;
import com.example.hostelManagement.service.hostel.HostelService;
import com.example.hostelManagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private HostelService hostelService;

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<?> createApplication(@RequestBody ApplicationDto applicationDto) {

        Hostel hostel = hostelService.getHostelById(applicationDto.getHostel_id());
        User user = userService.findById(applicationDto.getStd_id());
        if (hostel == null) {
            return ResponseEntity.ok("hostel not found");
        }
        if (user == null) {
            return ResponseEntity.ok("user not found");
        }
        applicationService.createApplication(applicationDto.getHostel_id(), applicationDto.getStd_id());
        return ResponseEntity.ok("rooms created successfully");
    }

    @GetMapping("/getForHostel")
    public ResponseEntity<?> getAllApplicationsForHostel(@RequestBody ApplicationDto applicationDto) {

        Hostel hostel = hostelService.getHostelById(applicationDto.getHostel_id());
        if (hostel == null) {
            return ResponseEntity.ok("hostel not found");
        }
        List<Application> applications = applicationService.getAllApplicationsForHostel(applicationDto.getHostel_id());
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/getForStudent")
    public ResponseEntity<?> getAllApplicationsForStudent(@RequestBody ApplicationDto applicationDto) {

        User user = userService.findById(applicationDto.getStd_id());

        if (user == null) {
            return ResponseEntity.ok("user not found");
        }
        List<Application> applications = applicationService.getAllApplicationsForStudent(applicationDto.getStd_id());
        return ResponseEntity.ok(applications);
    }

    @PutMapping("/changeStatus")
    public ResponseEntity<?> changeApplicationStatus(@RequestBody ChangeApplicationDto applicationDto){
        applicationService.changeApplicationStatus(applicationDto.getApplicationId(), applicationDto.getStatus());
        return ResponseEntity.ok("successfully updated status");
    }

}