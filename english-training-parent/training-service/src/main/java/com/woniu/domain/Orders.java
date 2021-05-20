package com.woniu.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private Integer id;
    private Integer userid;
    private Integer videoid;
    private Date orderTime;
    private String payType;
}
