package org.orak.thirthwebapplication.repository;

import org.orak.thirthwebapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserId(int id);
    int deleteUserByUserId(int userId);    //Bu metod, verilen id'ye sahip kullanıcıyı veritabanında arar ve bulduğu kullanıcıyı geri döndürür.

}
