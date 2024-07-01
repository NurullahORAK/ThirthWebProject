package org.orak.thirthwebapplication.controller;

import org.orak.thirthwebapplication.entity.User;
import org.orak.thirthwebapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Bu anotasyon, bu sınıfın bir RESTful web servis denetleyicisi olduğunu belirtir.
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;       // UserService sınıfı otomatik olarak enjekte edilir (dependency injection).

    //C create olustur
    //R READ oku
    //U UPDATE guncelle
    //D Delete sil

    //Rcihardson Maturity Model idompotency

    @GetMapping
    public User get(@RequestParam(value = "id")String id){
        return userService.get(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") String id) {
        userService.delete(id);
    }

//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAll();
//    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(name = "id") String id, @RequestBody User user) {
        return userService.update(id, user);
    }
}
