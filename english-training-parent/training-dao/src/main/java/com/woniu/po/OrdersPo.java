package com.woniu.po;

import lombok.Data;

import java.util.Date;
@Data
public class OrdersPo {
    private Integer id;
    private Integer userid;
    private Integer videoid;
    private Date orderTime;
    private String payType;
}
