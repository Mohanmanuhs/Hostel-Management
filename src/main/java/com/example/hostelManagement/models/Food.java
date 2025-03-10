package com.example.hostelManagement.models;

import com.example.hostelManagement.constants.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Hostel hostel;

    private Integer std_count;

}