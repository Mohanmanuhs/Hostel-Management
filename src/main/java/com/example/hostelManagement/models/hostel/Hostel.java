package com.example.hostelManagement.models.hostel;

import com.example.hostelManagement.models.Application;
import com.example.hostelManagement.models.FeesPayment;
import com.example.hostelManagement.models.user.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hostel_id;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Integer empty_seats;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column
    private String phone;

    @Column(nullable = false)
    private Integer fees;

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.REMOVE)
    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.REFRESH)
    private List<Staff> staffs = new ArrayList<>();

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.REMOVE)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.REFRESH)
    private List<FeesPayment> feesPayments = new ArrayList<>();

    @OneToOne(mappedBy = "hostel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Food food;

}