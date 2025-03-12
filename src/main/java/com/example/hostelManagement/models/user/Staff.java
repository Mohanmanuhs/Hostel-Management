package com.example.hostelManagement.models.user;

import com.example.hostelManagement.constants.Position;
import com.example.hostelManagement.models.hostel.Hostel;
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
public class Staff extends User {

    @Column
    private Position position;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Hostel hostel;

}
