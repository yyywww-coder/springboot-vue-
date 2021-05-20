package com.woniu.po;

import lombok.Data;

import java.util.Date;

@Data
public class ArrangePo {
    private Integer id;
    private String username;
    private Integer age;
    private String gender;
    private String telephone;
    private Date orderTime;
    private String className;
    private String status;
}
