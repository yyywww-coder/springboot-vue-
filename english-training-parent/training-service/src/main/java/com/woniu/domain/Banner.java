package com.woniu.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Banner {
    private Integer id;
    private String title;
    private String imageUrl;
    private String linkUrl;
    private Integer sort;
    private Integer isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}
