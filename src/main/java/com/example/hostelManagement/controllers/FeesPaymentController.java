package com.example.hostelManagement.controllers;


import com.example.hostelManagement.dto.ApplicationDto;
import com.example.hostelManagement.dto.FeesPaymentDto;
import com.example.hostelManagement.dto.VerifyPaymentDto;
import com.example.hostelManagement.models.Application;
import com.example.hostelManagement.models.FeesPayment;
import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.user.User;
import com.example.hostelManagement.repository.FeesPaymentRepo;
import com.example.hostelManagement.service.FeesPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("feesPayment")
public class FeesPaymentController {

    @Autowired
    private FeesPaymentService feesPaymentService;

    @PostMapping("/payFees")
    public ResponseEntity<?> payFees(@RequestBody FeesPaymentDto feesPaymentDto) {
        feesPaymentService.payFees(feesPaymentDto.getStd_id(), feesPaymentDto.getHostel_id(), feesPaymentDto.getAmount(), feesPaymentDto.getTransaction_id());
        return ResponseEntity.ok("fees paid successfully");
    }

    @PutMapping("/verify")
    public ResponseEntity<?> verifyPayment(@RequestBody VerifyPaymentDto verifyPaymentDto) {
        feesPaymentService.verifyPayment(verifyPaymentDto.getTransaction_id(),verifyPaymentDto.getPaymentStatus());
        return ResponseEntity.ok("verified successfully");
    }

    @GetMapping("/getForHostel")
    public ResponseEntity<?> getAllApplicationsForHostel(@RequestBody ApplicationDto applicationDto) {
        List<FeesPayment> allPaymentsForHostel = feesPaymentService.getAllPaymentsForHostel(applicationDto.getHostel_id());
        return ResponseEntity.ok(allPaymentsForHostel);
    }

    @GetMapping("/getForStudent")
    public ResponseEntity<?> getAllApplicationsForStudent(@RequestBody ApplicationDto applicationDto) {
        List<FeesPayment> allPaymentsForStudent = feesPaymentService.getAllPaymentsForStudent(applicationDto.getStd_id());
        return ResponseEntity.ok(allPaymentsForStudent);
    }

}