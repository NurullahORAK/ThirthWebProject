package org.orak.thirthwebapplication.service;

import org.orak.thirthwebapplication.entity.User;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    public  User getUser(){
        User user =new User();
        user.userId=1;
        user.userName="nurullahork";
        user.fullName="Nurullah Orak";
        return user;
    }
}
