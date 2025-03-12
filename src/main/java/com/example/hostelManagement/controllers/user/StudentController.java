package com.example.hostelManagement.controllers.user;


import com.example.hostelManagement.repository.user.StudentRepo;
import com.example.hostelManagement.service.user.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentController {

    @Autowired
    private StudentService studentService;

}