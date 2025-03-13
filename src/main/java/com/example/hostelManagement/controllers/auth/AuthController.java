package com.example.hostelManagement.controllers.auth;

import com.example.hostelManagement.repository.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private UserRepo userRepository;


    @GetMapping("/sessionExpired")
    public ResponseEntity<String> sessionExpiredPage() {
        return ResponseEntity.ok("your session has expired,please login again");
    }
}
