package com.woniu.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Video {
    private Integer id;
    private String videoSourceId;
    private Double price;
    private String description;
    private String title;
    private Integer teacherId;
    private Integer courseId;
    private String grade;
    private String imageUrl;
    private Date createTime;
    private String type;
    private String status;
    private String username;  //老师姓名
    private String createtime;

}
