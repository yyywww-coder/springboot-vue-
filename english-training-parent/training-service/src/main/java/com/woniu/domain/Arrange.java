package com.woniu.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Arrange {
    private Integer id;
    private String username;
    private Integer age;
    private String gender;
    private String telephone;
    private Date orderTime;
    private String className;
    private String status;
}
