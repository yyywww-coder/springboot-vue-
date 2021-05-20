package com.woniu.controller.managerController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Course;
import com.woniu.domain.Students;
import com.woniu.po.StudentsPo;
import com.woniu.service.managerService.CourseService;
import com.woniu.service.managerService.StudentsService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/student/")
public class StudentsController {

        @Autowired
        private StudentsService studentsService;
        @Autowired
        private CourseService courseService;

        /**
         * 列表分页
         * @return
         */
        @RequestMapping("list")
        public ResponseResult<PageInfo<Students>> list(Integer pageIndex, Integer pageSize, String seachText, String customs){

                StudentsPo student =new StudentsPo();
                //获得选中年级ID
                if(customs.equals("少儿")){
                        student.setCourseid(1);
                }else if(customs.equals("初中")){
                        student.setCourseid(2);
                }else if(customs.equals("高中")){
                        student.setCourseid(3);
                }
                student.setUsername(seachText);

                PageInfo<StudentsPo> poPageInfo = studentsService.getAllStudents(pageIndex,pageSize,student);
                PageInfo<Students> pageInfo = new PageInfo<>();
                BeanUtils.copyProperties(poPageInfo,pageInfo);


//                // 定义总记录数
//               int total=0;
//                total= studentsService.getTotal();
//                // 判断当前查找数据是否为空
//                if(seachText !=null && seachText !="" || student.getCourseid() !=null){
//                        for (Students allStudent : allStudents) {
//                                total++;
//                        }
//                }
//                System.out.println(total);
                // pageInfo.setTotal(total);
                //pageInfo.setPageNum(pageIndex);
                return new ResponseResult(pageInfo);
        }

        @RequestMapping("find")
        public ResponseResult<PageInfo<Students>> findStudent(Integer pageIndex, Integer pageSize, String searchText){

                if (searchText != null){
                        PageInfo<StudentsPo> poPageInfo = studentsService.findAll(pageIndex, pageSize, searchText);
                        PageInfo<Students> pageInfo = new PageInfo<>();
                        BeanUtils.copyProperties(poPageInfo,pageInfo);
                        return new ResponseResult<>(pageInfo);
                }else{
                        return null;
                }
        }





        /**
         * 修改学员
         * @return
         */
        @RequestMapping("update")
        public ResponseResult update(@RequestBody StudentsPo studentsPo){


                System.out.println(studentsPo.getUsername());
                studentsService.update(studentsPo);
                return ResponseResult.SUCCESS;
        }

        /**
         * 删除学员
         * @return
         */
        @RequestMapping("delete")
        public ResponseResult delete(Integer id){
                studentsService.delete(id);
                return ResponseResult.SUCCESS;
        }


        /**
         * 新增学员
         * @param studentsPo
         * @return
         */
        @RequestMapping("add")
        public ResponseResult add(@RequestBody StudentsPo studentsPo, Integer grade){
                studentsPo.setAvatar("/default.jpg");
                studentsPo.setStatus("0");
                studentsPo.setCourseid(grade);
                if (grade == 1){
                        studentsPo.setGrade("小学");
                }
                if (grade == 2){
                        studentsPo.setGrade("初中");
                }
                if (grade == 3){
                        studentsPo.setGrade("高中");
                }
                studentsPo.setMajor("英语");
                studentsService.add(studentsPo);
                return ResponseResult.SUCCESS;
        }


        @RequestMapping("course")
        public ResponseResult<List<Course>> courses(){
                List<Course> allGradeAndClass = courseService.findAllGradeAndClass();

                return new ResponseResult(allGradeAndClass);

        }

        @RequestMapping("num")
        public ResponseResult<Map<Object, Object>> num(){
                Map<Object, Object> map = new HashMap<>();
                List<Course> list1 = courseService.getCourse();
                List<Object> list = new ArrayList<>();
                for (int i = 0; i < list1.size(); i++) {

                        list.add(list1.get(i).getGrade());
                }
                map.put("list",list);



                List<Object> list2 = studentsService.getNum();
                System.out.println(list2);
                map.put("list2",list2);

                return new ResponseResult<>(map);

        }

}
