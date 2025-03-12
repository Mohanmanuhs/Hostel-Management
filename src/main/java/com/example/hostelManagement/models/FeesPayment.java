package com.example.hostelManagement.models;

import com.example.hostelManagement.constants.PaymentStatus;
import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.user.Student;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "hostel_id", "year"}))
public class FeesPayment {

    @Id
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Hostel hostel;

    private Integer year;

    private Integer amount;

    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

}