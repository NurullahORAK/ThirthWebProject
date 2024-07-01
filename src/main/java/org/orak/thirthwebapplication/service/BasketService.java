package org.orak.thirthwebapplication.service;

import org.orak.thirthwebapplication.entity.Basket;
import org.orak.thirthwebapplication.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
@Autowired
    private BasketRepository basketRepository;
    public Basket create(Basket basket) {
        return basketRepository.save(basket);
    }

    public Basket get(String id) {
        return basketRepository.findById(Integer.parseInt(id)).get();
    }

    public void delete(String id) {
        basketRepository.deleteById(Integer.parseInt(id));
    }

    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    public Basket updateBasket(String id, Basket basket) {    //id parametresi bir kullanıcıyı tanımlayan bir String ve user parametresi güncellenmiş kullanıcı bilgilerini içeren bir User nesnesidir.
        //Metod, güncellenmiş User nesnesini geri döndürür.
        Basket existBasket = basketRepository.findById(Integer.parseInt(id)).get();
        existBasket.setBasketId(existBasket.getBasketId());
        existBasket.setProductName(existBasket.getProductName());
        //existBasket.setUserId(existBasket.getUserId());
        return basketRepository.save(existBasket);
    }
}
