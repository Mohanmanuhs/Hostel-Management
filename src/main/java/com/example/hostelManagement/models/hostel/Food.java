package com.example.hostelManagement.models.hostel;

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

    @Id
    private Integer food_id;

    @OneToOne
    @JoinColumn(name = "hostel_id")
    @MapsId
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Hostel hostel;

    private Integer std_count;

}