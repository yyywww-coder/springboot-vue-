package com.woniu.domain;

import lombok.Data;

@Data
public class Exam {
    private Integer examCode;
    private String description;
    private String source;
    private Integer paperId;
    private String examDate;
    private Integer totalTime;
    private String grade;
    private String term;
    private String major;
    private String institute;
    private Integer totalScore;
    private String tips;
    private String type;
}
