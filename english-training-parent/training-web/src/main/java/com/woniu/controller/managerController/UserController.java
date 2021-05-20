package com.woniu.controller.managerController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.User;
import com.woniu.po.UserPo;
import com.woniu.service.managerService.UserService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查找用户列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("list")
    public ResponseResult<PageInfo> userList(Integer pageIndex, Integer pageSize, String searchName, String status){

       PageInfo<UserPo> poPageInfo = userService.findAllUsers(pageIndex,pageSize,searchName,status);
       PageInfo<User> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(poPageInfo,pageInfo);
        return new ResponseResult<>(pageInfo);

    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("update")
    public ResponseResult updateUser(String status, Integer id){

        userService.updateUser(status,id);
        System.out.println(status+"```````````````"+id);
            return new ResponseResult(200,"修改成功");
    }

}
