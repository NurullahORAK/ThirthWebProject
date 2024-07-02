package org.orak.thirthwebapplication.dto;
import org.orak.thirthwebapplication.entity.User;

public class BasketDto {
    private int basketId;
    private UserDto user;

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
