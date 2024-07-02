package org.orak.thirthwebapplication.controller;

import org.orak.thirthwebapplication.dto.BasketDto;
import org.orak.thirthwebapplication.dto.BasketRequest;
import org.orak.thirthwebapplication.dto.UserDto;
import org.orak.thirthwebapplication.entity.Basket;
import org.orak.thirthwebapplication.service.BasketService;
import org.orak.thirthwebapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baskets")

public class BasketController {
    @Autowired
    private BasketService basketService;

    //C create olustur
    //R READ oku
    //U UPDATE guncelle
    //D Delete sil

    //Rcihardson Maturity Model idompotency

    @GetMapping
    public Basket get(@RequestParam(value = "userId") String userId) {
        return basketService.get(userId);
    }

    @PostMapping
    public Basket create(@RequestBody BasketRequest basket) {
        return basketService.create(toDto(basket));
    }  // gelen objeyi dto ya çeviriyor.

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        basketService.delete(id);
    }

    @PutMapping("/{id}")
    public Basket update(@PathVariable(name = "id") String id, @RequestBody BasketRequest basket) {
        return basketService.updateBasket(id, toDto(basket));
    }

    public BasketDto toDto(BasketRequest request) { // Bu method parametre olarak dışardan gelen BasketRequest objesini alıyor.
        BasketDto dto = new BasketDto();   // sonra BasketDto yu new liyor
        dto.setUser(new UserDto(request.userId));   // ve dto alanlarına set edşyor
        dto.setBasketId(request.basketId);          // yukarıdaki ile aynı
        return dto;     // Yani yapmış olduğu şey gelen objeyi tutup dto ya çeviriyor.
    }

}
