package com.woniu.service.managerService;

import com.woniu.domain.Course;

import java.util.List;

public interface CourseService {

        //查找所有班级
        public List<Course> findAllGradeAndClass();


        //查询科目
        public List<Course> getCourse();

}
