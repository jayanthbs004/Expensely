package com.expensely.expensely_backend.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Map<String, Object> createUser(@RequestBody Users user) {
        Users savedUser = userService.createUser(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully!");
        response.put("user", savedUser);
        return response;
    }

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
}
