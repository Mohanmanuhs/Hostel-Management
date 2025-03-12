package com.example.hostelManagement.service;


import com.example.hostelManagement.repository.ApplicationRepo;
import com.example.hostelManagement.repository.user.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;

}