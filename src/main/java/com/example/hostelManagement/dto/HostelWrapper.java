package com.example.hostelManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HostelWrapper {
    private UserLoginRequest loginRequest;
    private HostelDto hostelDto;
}