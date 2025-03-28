package com.example.hostelManagement.repository.user;

import com.example.hostelManagement.models.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);

    @Transactional
    @Modifying
    void deleteByEmail(String email);

}
