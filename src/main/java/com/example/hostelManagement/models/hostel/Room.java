package com.example.hostelManagement.models.hostel;

import com.example.hostelManagement.models.user.Student;
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
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer room_id;

    private Integer room_no;

    private Integer floor_no;

    @Column(nullable = false)
    private Integer total_seats;

    @Column(nullable = false)
    private Integer empty_seats;

    @ManyToOne
    @JoinColumn(name = "hostel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Hostel hostel = new Hostel();

    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Student> students = new ArrayList<>();

}