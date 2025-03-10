package com.example.hostelManagement.models;

import com.example.hostelManagement.constants.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    @MapsId("hostelId")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Hostel hostel;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

}