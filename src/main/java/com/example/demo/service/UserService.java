package com.example.backendproject.service;

import com.example.backendproject.model.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);

    User findByEmail(String email);

    List<User> getAllUsers();

    User getUserById(Long id);
}
