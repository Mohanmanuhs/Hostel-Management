package com.example.hostelManagement.models;

import com.example.hostelManagement.constants.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Application {

    @EmbeddedId
    private ApplicationId id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "hostel_id", nullable = false)
    @MapsId("hostelId")
    private Hostel hostel;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

}