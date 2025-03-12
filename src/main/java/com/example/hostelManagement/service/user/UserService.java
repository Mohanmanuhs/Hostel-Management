package com.example.hostelManagement.service.user;


import com.example.hostelManagement.dto.ChangePassDto;
import com.example.hostelManagement.models.user.User;
import com.example.hostelManagement.repository.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User changePassword(ChangePassDto changePassDto) {
        User user = userRepo.findByEmail(changePassDto.getEmail());
        user.setPassword(changePassDto.getNewPassword());
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findById(Integer id) {
        return userRepo.findById(id).orElseThrow();
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public void deleteUserByEmail(String email) {
        userRepo.deleteByEmail(email);
    }
}