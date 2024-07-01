package org.orak.thirthwebapplication.controller;

import org.orak.thirthwebapplication.entity.Basket;
import org.orak.thirthwebapplication.service.BasketService;
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
    /*@GetMapping("/{id}")
    public Basket get(@PathVariable(name = "id") String id) {
        return basketService.get(id);
    }*/
    @GetMapping
    public Basket get(@RequestParam(value = "userId") String userId)
    {
        return basketService.get(userId);
    }

    @PostMapping
    public Basket create(@RequestBody Basket basket) {
        return basketService.create(basket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        basketService.delete(id);
    }

//    @GetMapping
//    public List<Basket> getAll() {
//        return basketService.getAll();
//    }

    @PutMapping("/{id}")
    public Basket update(@PathVariable(name = "id") String id, @RequestBody Basket basket) {
        return basketService.updateBasket(id, basket);
    }
}
