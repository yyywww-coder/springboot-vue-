package com.woniu.service.managerService.impl;

import com.woniu.adapter.managerAdapter.CourseAdapter;
import com.woniu.domain.Course;
import com.woniu.exception.ManagerException;
import com.woniu.service.managerService.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

        @Autowired
        private CourseAdapter courseAdapter;


        @Override
        public List<Course> findAllGradeAndClass() {
                List<Course> courseLists = courseAdapter.findCourseLists();
                if (courseLists ==null) {
                        throw new ManagerException("无课程相关数据");
                }

                return courseLists;
        }

        @Override
        public List<Course> getCourse() {
                return courseAdapter.findCourse();
        }
}
