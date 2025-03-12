package com.example.hostelManagement.service;


import com.example.hostelManagement.constants.Status;
import com.example.hostelManagement.models.Application;
import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.user.Student;
import com.example.hostelManagement.repository.ApplicationRepo;
import com.example.hostelManagement.repository.hostel.HostelRepo;
import com.example.hostelManagement.repository.user.StudentRepo;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private HostelRepo hostelRepo;

    public void createApplication(int studentId, int hostelId) {
        Optional<Student> student = studentRepo.findById(studentId);
        Optional<Hostel> hostel = hostelRepo.findById(hostelId);

        Application application = new Application();
        if(student.isPresent() && hostel.isPresent()) {
            application.setHostel(hostel.get());
            application.setStudent(student.get());
            applicationRepo.save(application);
        }
    }

    public List<Application> getAllApplicationsForHostel(Integer hostelId) {
        Optional<Hostel> hostel = hostelRepo.findById(hostelId);
        if(hostel.isPresent()) {
            return applicationRepo.findAllByHostel(hostel.get());
        }
        return Collections.emptyList();
    }

    public List<Application> getAllApplicationsForStudent(Integer studentId) {
        Optional<Student> student = studentRepo.findById(studentId);
        if(student.isPresent()) {
            return applicationRepo.findAllByStudent(student.get());
        }
        return Collections.emptyList();
    }

    public void changeApplicationStatus(Integer application_id, Status status) {
        Optional<Application> application = applicationRepo.findById(application_id);

        if(application.isPresent()) {
            application.get().setStatus(status);
            applicationRepo.save(application.get());
        }
    }


}