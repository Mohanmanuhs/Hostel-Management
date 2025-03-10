package com.example.hostelManagement.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student extends User {

    @ManyToOne
    @JoinColumn(name = "room_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Room room;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REFRESH)
    private List<Application> applications;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REFRESH)
    private List<FeesPayment> feesPayments;

}
