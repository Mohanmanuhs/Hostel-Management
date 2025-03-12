package com.example.hostelManagement.controllers.user;


import com.example.hostelManagement.repository.user.StaffRepo;
import com.example.hostelManagement.service.user.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffController {

    @Autowired
    private StaffService staffService;

}