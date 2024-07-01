package org.orak.thirthwebapplication.repository;

import org.orak.thirthwebapplication.entity.Basket;
import org.orak.thirthwebapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Integer> {
    // Basket findByUserId(int id);
    void deleteBasketByUser_UserId(int userId);  // eğer Jpa OneToOne relationship varsa , silmek istiyorsan userId ye göre bu kod yazılır.
                                                 // Basket ın içerisinde User var onun içerisinde userId var. O fieald a göre ilgili basket ı sil demek oluyor.
}
