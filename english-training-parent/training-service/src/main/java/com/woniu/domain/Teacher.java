package com.woniu.domain;

import lombok.Data;

@Data
public class Teacher {
    private int id;
    private String account;
    private String password;
    private String username;
    private String gender;
    private int age;
    private String education;
    private String isfamous;
    private String telephone;
    private String status;

    private String imageUrl;
}
