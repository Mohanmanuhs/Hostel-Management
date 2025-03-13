package com.example.hostelManagement.controllers.hostel;


import com.example.hostelManagement.models.hostel.Food;
import com.example.hostelManagement.models.user.Staff;
import com.example.hostelManagement.models.user.Student;
import com.example.hostelManagement.repository.hostel.FoodRepo;
import com.example.hostelManagement.service.hostel.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/get")
    public Optional<Food> getFood(Integer hostelId) {
        return foodService.getFood(hostelId);
    }

    @PutMapping("/incCount")
    public void incrementCount(Student student) {
        foodService.incrementCount(student);
    }

    @PutMapping("/clearCount")
    public void clearCount(Staff staff) {
        foodService.clearCount(staff);
    }

}