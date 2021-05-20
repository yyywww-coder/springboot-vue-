package com.woniu.domain;

import lombok.Data;


@Data
public class Course {

        private Integer id;
        private String grade;
        private Integer classid;
        private Integer teacherid;
        private String beginTime;
        private String endTime;
        private String className;

}
