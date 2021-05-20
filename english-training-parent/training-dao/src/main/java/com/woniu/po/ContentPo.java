package com.woniu.po;

import lombok.Data;

@Data
public class ContentPo {
    private Integer id;
    private String name;
    private String link;
    private int parentid;
    private String status;
}
