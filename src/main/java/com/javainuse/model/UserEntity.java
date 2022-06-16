package com.javainuse.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String login;

    String password;

}


