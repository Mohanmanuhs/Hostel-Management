package com.example.hostelManagement.models;

import com.example.hostelManagement.constants.Status;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Food {

    @OneToOne
    @JoinColumn(name = "hostel_id", nullable = false)
    @MapsId
    private Hostel hostel;

    private Integer std_count;

}