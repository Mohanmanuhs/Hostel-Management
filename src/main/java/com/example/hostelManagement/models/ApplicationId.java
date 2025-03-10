package com.example.hostelManagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ApplicationId implements Serializable {

    private Integer studentId;
    private Integer hostelId;

}
