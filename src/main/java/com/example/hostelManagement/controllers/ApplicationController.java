package com.example.hostelManagement.controllers;


import com.example.hostelManagement.repository.ApplicationRepo;
import com.example.hostelManagement.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

}