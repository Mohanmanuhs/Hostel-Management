package com.example.hostelManagement.repository.hostel;

import com.example.hostelManagement.models.hostel.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostelRepo extends JpaRepository<Hostel,Integer> {

    List<Hostel> findByNameContainingIgnoreCase(String name);

    List<Hostel> findByLocationContainingIgnoreCase(String location);

    List<Hostel> findByFeesLessThan(Integer fees);

}