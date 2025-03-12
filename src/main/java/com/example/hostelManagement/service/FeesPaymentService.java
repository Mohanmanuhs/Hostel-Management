package com.example.hostelManagement.service;


import com.example.hostelManagement.constants.PaymentStatus;
import com.example.hostelManagement.models.FeesPayment;
import com.example.hostelManagement.models.hostel.Hostel;
import com.example.hostelManagement.models.user.Student;
import com.example.hostelManagement.repository.FeesPaymentRepo;
import com.example.hostelManagement.repository.hostel.HostelRepo;
import com.example.hostelManagement.repository.user.StudentRepo;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorTiDBDatabaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.swing.text.html.Option;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Year;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FeesPaymentService {

    @Autowired
    private FeesPaymentRepo feesPaymentRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private HostelRepo hostelRepo;

    public void payFees(Integer student_id, Integer hostel_id, Integer amount,String transaction_id) {
        FeesPayment feesPayment = new FeesPayment();
        feesPayment.setTransactionId(transaction_id);
        feesPayment.setHostel(hostelRepo.findById(hostel_id).orElse(null));
        feesPayment.setStudent(studentRepo.findById(student_id).orElse(null));
        feesPayment.setAmount(amount);
        feesPayment.setYear(Year.now().getValue());
        feesPaymentRepo.save(feesPayment);
    }

    public void verifyPayment(String transaction_id, PaymentStatus paymentStatus) {
        FeesPayment feesPayment = feesPaymentRepo.findByTransactionId(transaction_id).orElse(null);
        if(feesPayment!= null) {
            feesPayment.setPaymentStatus(paymentStatus);
            feesPaymentRepo.save(feesPayment);
        }
    }

    public List<FeesPayment> getAllPaymentsForStudent(Integer student_id) {
        Optional<Student> student = studentRepo.findById(student_id);
        if(student.isPresent()) {
            return student.get().getFeesPayments();
        }
        return Collections.emptyList();
    }

    public List<FeesPayment> getAllPaymentsForHostel(Integer hostel_id) {
        Optional<Hostel> hostel = hostelRepo.findById(hostel_id);
        if(hostel.isPresent()) {
            return hostel.get().getFeesPayments();
        }
        return Collections.emptyList();
    }
}