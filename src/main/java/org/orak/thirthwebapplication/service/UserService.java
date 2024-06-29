package org.orak.thirthwebapplication.service;

import org.orak.thirthwebapplication.entity.User;
import org.orak.thirthwebapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User getUser(String id) {
        return repository.findById(Integer.parseInt(id)).orElse(null);
    }

    public User deleteUser(String id) {
        return repository.findById(Integer.parseInt(id)).orElse(null);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(User user) {
        return repository.findById(Integer.parseInt(String.valueOf(user.userId))).orElse(null);
    }
}
