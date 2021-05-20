package com.woniu.adapter.managerAdapter;


import com.woniu.dao.managerDao.CourseDao;
import com.woniu.domain.Course;
import com.woniu.po.CoursePo;
import com.woniu.redis.managerRedisDao.CourseRedisDao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@SuppressWarnings("all")
public class CourseAdapter {

   @Autowired
    private CourseDao courseDao;

   @Autowired
    private CourseRedisDao courseRedisDao;

    

    /**
     * 查所有
     * @return
     */
    public List<Course> findCourseLists() {
        List<CoursePo> allGradeAndClass = courseDao.findAllGradeAndClass();
        List<Course> courses = new ArrayList<>();
        for (CoursePo gradeAndClass : allGradeAndClass) {
            Course course = new Course();
            BeanUtils.copyProperties(gradeAndClass,course);
            courses.add(course);
        }
        return courses;
    }

    public List<Course> findCourse(){
        List<CoursePo> coursePoList = courseDao.getCourse();
        List<Course> courses = new ArrayList<Course>();
        for(CoursePo coursePo : coursePoList) {
            Course item = new Course();
            BeanUtils.copyProperties(coursePo, item);
            courses.add(item);
        }
        return courses;
    }
}
