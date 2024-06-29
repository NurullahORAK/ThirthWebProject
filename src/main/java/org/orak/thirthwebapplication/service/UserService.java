package org.orak.thirthwebapplication.service;

import org.orak.thirthwebapplication.entity.User;
import org.orak.thirthwebapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired
    private UserRepository repository;
    public  User getUser(){
        User user =new User();
        user.userId=1;
        user.userName="nurullahork";
        user.fullName="Nurullah Orak";
        return user;
    }
}
