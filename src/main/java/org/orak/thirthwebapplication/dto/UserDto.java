package org.orak.thirthwebapplication.dto;

import jakarta.persistence.*;
import org.orak.thirthwebapplication.entity.User;
@Entity
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int userId;
    public String userName;
    public String fullName;
    public String password;
    public String birthDate;
    public String birthPlace;
    public String tckn;

    public UserDto(int userId) {
        this.userId = userId;
    }
}
