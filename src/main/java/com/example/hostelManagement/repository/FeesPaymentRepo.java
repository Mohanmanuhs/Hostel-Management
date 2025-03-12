package com.example.hostelManagement.repository;

import com.example.hostelManagement.models.Application;
import com.example.hostelManagement.models.FeesPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FeesPaymentRepo extends JpaRepository<FeesPayment,Integer> {
    Optional<FeesPayment> findByTransactionId(String transactionId);
}
