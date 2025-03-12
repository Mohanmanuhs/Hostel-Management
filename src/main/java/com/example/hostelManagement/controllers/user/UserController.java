package com.example.hostelManagement.controllers.user;


import com.example.hostelManagement.dto.ChangePassDto;
import com.example.hostelManagement.dto.UserLoginRequest;
import com.example.hostelManagement.dto.UserRegisterRequest;
import com.example.hostelManagement.models.user.Staff;
import com.example.hostelManagement.models.user.Student;
import com.example.hostelManagement.models.user.User;
import com.example.hostelManagement.service.user.StaffService;
import com.example.hostelManagement.service.user.StudentService;
import com.example.hostelManagement.service.user.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterRequest userRequest) {
        System.out.println("userRequest: " + userRequest);
        if (userService.findByEmail(userRequest.getEmail()) != null) {
            return ResponseEntity.ok("already registered user");
        }

        try {
            User user = null;
            switch (userRequest.getRole()) {
                case STAFF -> {
                    Staff staff = getStaff(userRequest);
                    user = staffService.createStaff(staff);
                }
                case STUDENT -> {
                    Student student = getStudent(userRequest);
                    user = studentService.createStudent(student);
                }
            }
            userService.createUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginRequest userRequest) {

        User user = userService.findByEmail(userRequest.getEmail());

        if (user == null) {
            return ResponseEntity.ok("user not found");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout successfully";
    }

    @PostMapping("/changePassword")
    public ResponseEntity<User> changePassword(@RequestBody @Valid ChangePassDto changePassDto) {
        User user = userService.changePassword(changePassDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody @Valid UserLoginRequest userRequest) {
        User user = userService.findByEmail(userRequest.getEmail());
        if (user == null) {
            return ResponseEntity.ok("user not found");
        }
        if (!Objects.equals(user.getPassword(), userRequest.getPassword())) {
            return ResponseEntity.ok("incorrect password");
        }
        userService.deleteUserByEmail(userRequest.getEmail());
        return ResponseEntity.ok("user deleted");
    }

    private static Staff getStaff(UserRegisterRequest userRequest) {
        Staff staff = new Staff();
        staff.setEmail(userRequest.getEmail());
        staff.setName(userRequest.getName());
        staff.setPassword(userRequest.getPassword());
        staff.setAddress(userRequest.getAddress());
        staff.setPhone(userRequest.getPhone());
        staff.setRole(userRequest.getRole());
        staff.setPosition(userRequest.getPosition());
        return staff;
    }

    private static Student getStudent(UserRegisterRequest userRequest) {
        Student student = new Student();
        student.setEmail(userRequest.getEmail());
        student.setName(userRequest.getName());
        student.setPassword(userRequest.getPassword());
        student.setPhone(userRequest.getPhone());
        student.setRole(userRequest.getRole());
        student.setAddress(userRequest.getAddress());
        return student;
    }

}