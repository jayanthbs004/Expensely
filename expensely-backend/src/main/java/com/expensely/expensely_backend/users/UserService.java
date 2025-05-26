package com.expensely.expensely_backend.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to generate custom User ID
    private String generateUserId() {
        long count = userRepository.count() + 1; // Next user count
        int year = Year.now().getValue() % 100;  // Last two digits of year (e.g., 25 for 2025)
        return String.format("%02d%04d", year, count); // Example: 250003
    }

    public Users createUser(Users user) {
        user.setUserId(generateUserId()); // Set generated userId before saving
        return userRepository.save(user);
    }

    public Users getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public java.util.List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
