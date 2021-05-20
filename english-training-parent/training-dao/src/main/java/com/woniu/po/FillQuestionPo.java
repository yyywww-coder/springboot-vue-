package com.woniu.po;

import lombok.Data;


@Data
public class FillQuestionPo {

    private Integer questionId;

    private String subject;

    private String question;

    private String answer;

    private Integer score;

    private String level;

    private String section;

    private String analysis; //题目解析

    private String type; //新加题目类型

}
