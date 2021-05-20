package com.woniu.domain;

import com.woniu.po.UserPo;
import com.woniu.po.VideoPo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: ekang
 * @date: 2021/4/29 17:41
 * @description:后台实体类
 */
@Data
public class Order {
//    private int id;
//    private int userid;
//    private int videoid;
//    private Date orderTime;
//    private String payType;
//    private int log;
//    private UserPo user;
//    private VideoPo video;
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

