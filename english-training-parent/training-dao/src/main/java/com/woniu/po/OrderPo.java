package com.woniu.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: ekang
 * @date: 2021/4/29 17:41
 * @description:后台实体类
 */
@Data
public class OrderPo {
    private int id;
    private int userid;
    private int videoid;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date orderTime;
    private String payType;
    private int log;
    private String username;
    private String videoname;
}

