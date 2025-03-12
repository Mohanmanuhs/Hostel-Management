package com.example.hostelManagement.controllers.hostel;


import com.example.hostelManagement.repository.hostel.FoodRepo;
import com.example.hostelManagement.service.hostel.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodController {

    @Autowired
    private FoodService foodService;

}