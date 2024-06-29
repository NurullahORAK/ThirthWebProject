package org.orak.thirthwebapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int userId;
    public String userName;
    public String fullName;
    public String password;
    public String birthDate;
    public String birthPlace;
    public String tckn;
}
