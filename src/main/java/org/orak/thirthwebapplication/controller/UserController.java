package org.orak.thirthwebapplication.controller;

import org.orak.thirthwebapplication.entity.User;
import org.orak.thirthwebapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable (name ="id")String id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user ){
        return userService.saveUser(user);
    }
}
