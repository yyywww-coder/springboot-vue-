package com.woniu.po;


import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class UserPo {

    private Integer id;
    private String account;
    private String username;
    private String gender;
    private Integer age;
    private String phone;
    private String pName; //家长姓名
    private String pPhone; //家长电话
    private String password;
    private String email;
    private String address;
    private int courseid;
    private String comment; //老师评价
    //用来保存图片的路径的
    private String avatar;
    private String status;
}
