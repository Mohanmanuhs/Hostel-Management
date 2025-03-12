package com.example.hostelManagement.controllers;


import com.example.hostelManagement.repository.FeesPaymentRepo;
import com.example.hostelManagement.service.FeesPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeesPaymentController {

    @Autowired
    private FeesPaymentService feesPaymentService;

}