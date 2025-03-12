package com.example.hostelManagement.controllers.user;


import com.example.hostelManagement.repository.user.UserRepo;
import com.example.hostelManagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserController {

    @Autowired
    private UserService userService;

}