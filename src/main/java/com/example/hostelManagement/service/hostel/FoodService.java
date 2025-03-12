package com.example.hostelManagement.service.hostel;


import com.example.hostelManagement.repository.hostel.FoodRepo;
import com.example.hostelManagement.repository.user.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;

}