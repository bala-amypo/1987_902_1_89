package com.example.backendproject.service;

import com.example.backendproject.model.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);   
}
