package com.woniu.controller.frontController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Manager;
import com.woniu.domain.Order;
import com.woniu.domain.Survey;
import com.woniu.domain.Teacher;
import com.woniu.po.ManagerPo;
import com.woniu.po.TeacherPo;
import com.woniu.service.managerService.ManagerService;
import com.woniu.service.managerService.SurveyManagerService;
import com.woniu.service.managerService.TeacherService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TeacherFrontContreoller <br/>
 * Description: <br/>
 * date: 2021/5/8 10:50<br/>
 *
 * @author hasee<br />
 */
@RestController
@CrossOrigin
@RequestMapping("front/teacher")
public class TeacherFrontContreoller {
    @Autowired
    private TeacherService managerService;

    /**
     * 列表遍历
     */
    @RequestMapping("/list")
    public ResponseResult<PageInfo<TeacherPo>> findAll(Integer pageIndex, Integer pageSize){
        System.out.println("进入教师list查询");
        //用户名查询
        System.out.println("pageIndex"+pageIndex);
        System.out.println("pageSize"+pageSize);
        //查询列表
        String username="";
        PageInfo<TeacherPo> managerPageInfo = managerService.findByUsername(pageIndex,pageSize,username);
        System.out.println(managerPageInfo);
        return new ResponseResult<PageInfo<TeacherPo>>(managerPageInfo);
    }

    /**
     * 教师详情
     */
    @RequestMapping("/item")
    public ResponseResult<Teacher> findByid(Integer id){
        System.out.println("进入教师详情查询");
        Teacher teacher=new Teacher();

        teacher= managerService.findByid(id);
        System.out.println(teacher);

        return new ResponseResult<Teacher>(teacher);
    }
}
