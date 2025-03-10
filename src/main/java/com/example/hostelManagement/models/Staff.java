package com.example.hostelManagement.models;

import com.example.hostelManagement.constants.Position;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Staff extends User {

    @Column
    private Position position;

    @ManyToOne
    @JoinColumn(name = "hostel_id", nullable = false)
    private Hostel hostel;

}
