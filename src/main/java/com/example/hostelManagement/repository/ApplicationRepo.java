package com.example.hostelManagement.repository;

import com.example.hostelManagement.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Integer> {
}
