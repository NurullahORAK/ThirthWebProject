package org.orak.thirthwebapplication.service;

import org.orak.thirthwebapplication.entity.User;
import org.orak.thirthwebapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(String id) {
        return userRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(Integer.parseInt(id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(String id, User user) {
        User existUser = userRepository.findByUserId(Integer.parseInt(id));
        existUser.userName = user.userName;
        existUser.fullName = user.fullName;
        existUser.birthPlace = user.birthPlace;
        existUser.birthDate = user.birthDate;
        existUser.tckn = user.tckn;
        return userRepository.save(existUser);
    }
}
