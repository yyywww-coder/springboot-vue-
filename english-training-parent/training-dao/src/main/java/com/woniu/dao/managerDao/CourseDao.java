package com.woniu.dao.managerDao;

import com.woniu.po.CoursePo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseDao {
        //查找所有班级
        public List<CoursePo> findAllGradeAndClass();

        //查询人数
        public List<CoursePo> getCourse();
}
