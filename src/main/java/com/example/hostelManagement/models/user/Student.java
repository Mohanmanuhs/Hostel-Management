package com.example.hostelManagement.models.user;

import com.example.hostelManagement.models.Application;
import com.example.hostelManagement.models.FeesPayment;
import com.example.hostelManagement.models.hostel.Room;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
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
    private Room room = null;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REFRESH)
    private List<Application> applications = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.REFRESH)
    private List<FeesPayment> feesPayments = new ArrayList<>();

}
