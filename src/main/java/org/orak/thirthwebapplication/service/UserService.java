package org.orak.thirthwebapplication.service;

import org.orak.thirthwebapplication.entity.User;
import org.orak.thirthwebapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // Bu anotasyon, bu sınıfın bir servis bileşeni olduğunu belirtir.

public class UserService {

    @Autowired
    private UserRepository userRepository;      // UserRepository, kullanıcı verilerini veritabanından almak için kullanılır.

    public User create(User user) {
        return userRepository.save(user);
    }

    public User get(String id) {
        return userRepository.findByUserId(Integer.parseInt(id));
    }

    public void delete(String id) {
        userRepository.deleteById(Integer.parseInt(id));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(String id, User user) {    //id parametresi bir kullanıcıyı tanımlayan bir String ve user parametresi güncellenmiş kullanıcı bilgilerini içeren bir User nesnesidir.
                                                      //Metod, güncellenmiş User nesnesini geri döndürür.
        User existUser = userRepository.findByUserId(Integer.parseInt(id));
        existUser.userName = user.userName;
        existUser.fullName = user.fullName;
        existUser.birthPlace = user.birthPlace;
        existUser.birthDate = user.birthDate;
        existUser.tckn = user.tckn;
        return userRepository.save(existUser);
    }
}
