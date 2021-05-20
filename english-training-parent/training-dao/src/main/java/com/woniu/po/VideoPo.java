package com.woniu.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class VideoPo {
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
    private String username;
}
