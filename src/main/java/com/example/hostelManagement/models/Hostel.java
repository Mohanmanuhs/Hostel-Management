package com.example.hostelManagement.models;

import com.example.hostelManagement.constants.Role;
import jakarta.persistence.*;
import lombok.*;

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
    private String address;

    @Column
    private String phone;

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.REMOVE)
    private List<Application> applications;

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.REFRESH)
    private List<Staff> staffs;

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.REMOVE)
    private List<Room> rooms;

    @OneToMany(mappedBy = "hostel", cascade = CascadeType.REFRESH)
    private List<FeesPayment> feesPayments;

    @OneToOne(mappedBy = "hostel", cascade = CascadeType.REMOVE)
    private Food food;

}