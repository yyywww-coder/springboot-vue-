package com.woniu.po;

import lombok.Data;

@Data
public class CoursePo {
        private Integer id;
        private String grade;
        private Integer classid;
        private Integer teacherid;
        private String beginTime;
        private String endTime;
        private String className;
}
