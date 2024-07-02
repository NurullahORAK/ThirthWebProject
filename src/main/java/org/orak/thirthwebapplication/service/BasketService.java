package org.orak.thirthwebapplication.service;

import org.orak.thirthwebapplication.dto.BasketDto;
import org.orak.thirthwebapplication.entity.Basket;
import org.orak.thirthwebapplication.entity.User;
import org.orak.thirthwebapplication.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private UserService userService;

    public Basket create(BasketDto dto) {
        return basketRepository.save(toEntity(dto));   //Aşağıdaki toEntity metodundan sonra burda toEntity metodundan dto yu çağırıyoruz.
    }
    // Repository benden Entity istiyor ama bende dto var . Bunu çevirmek için toEntity metodu kullanılır.


    public Basket toEntity(BasketDto dto) {  // Repository benden Entity istiyor ama bende dto var
        Basket basket = new Basket();
        basket.setBasketId(dto.getBasketId());
        User user= userService.get(String.valueOf(dto.getUser().userId));  // User ın userService indeki get metodundan bulmasını söyledim o bana buldu geri döndü sonea burdaki user ı aşağıdaki setUser a koyduk.
        basket.setUser(user);
        return basket;
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

    public Basket updateBasket(String id, BasketDto dto) {    //id parametresi bir kullanıcıyı tanımlayan bir String ve user parametresi güncellenmiş kullanıcı bilgilerini içeren bir User nesnesidir.
        //Metod, güncellenmiş User nesnesini geri döndürür.
        Basket existBasket = basketRepository.findById(Integer.parseInt(id)).get();
        existBasket.setBasketId(existBasket.getBasketId());
        existBasket.setProductName(existBasket.getProductName());
        //existBasket.setUserId(existBasket.getUserId());
        return basketRepository.save(existBasket);
    }
}
