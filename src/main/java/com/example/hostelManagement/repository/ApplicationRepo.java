package com.example.hostelManagement.repository;

import com.example.hostelManagement.models.Application;
import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Integer> {

    List<Application> findAllByHostel(Hostel hostel);
    List<Application> findAllByStudent(Student student);

    boolean existsByStudentAndHostel(Student student, Hostel hostel);

}
