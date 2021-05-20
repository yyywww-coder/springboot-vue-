package com.woniu.domain;

import lombok.Data;

/**
 * @author: ekang
 * @date: 2021/4/29 17:41
 * @description:
 */
@Data
public class Survey {
    private int id ;
    private String sRemarks;//学生评论（简）
    private String tRemarks;//教师评论（简）
    private String suggestions;//建议（简）
    private int log ;

}

