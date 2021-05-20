package com.woniu.controller.managerController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Order;
import com.woniu.domain.Survey;
import com.woniu.domain.User;
import com.woniu.domain.Video;
import com.woniu.service.managerService.*;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderManagerService orderManagerService;


//    待后期优化
@Autowired
    private VideoService videoService;

@Autowired
    private UserService userService;

    /**
     * 所有
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult<PageInfo<Order>> findAll(Integer pageIndex, Integer pageSize, String name){
        System.out.println("进入list查询");
        //用户名查询
        System.out.println("pageIndex"+pageIndex);
        System.out.println("pageSize"+pageSize);
        System.out.println("name"+name);

        //视屏名

        //下单时间

        PageInfo<Order> orderList = orderManagerService.list(pageIndex,  pageSize,name);

        return new ResponseResult<PageInfo<Order>>(orderList);
    }



    /**
     * 添加
     */
    @RequestMapping("adds")
//    public ResponseResult addOrder(@RequestBody Order order){
    public ResponseResult addOrder(@RequestBody Order order){
        System.out.println("进入添加方法");
        System.out.println(order);
        String username=order.getUsername();
            User user=userService.findByUserName(username);
        if(user==null){
            return new ResponseResult(500,"添加失败，该用户不存在");
        }

        String videoname=order.getVideoname();
        Video video=videoService.findByVideoName(videoname);
        if(video==null){
            return new ResponseResult(500,"添加失败，该视频不存在");
        }

        int flag=orderManagerService.add(order);
        if(flag==1){
            return new ResponseResult(200,"添加成功");
        }else{
            return new ResponseResult(500,"添加失败");
        }
    }



    /**
     * 删除
     */
    @RequestMapping("delete")
    public ResponseResult del(Integer id){
        System.out.println("进入删除方法");
        int flag=orderManagerService.remove(id);
        if(flag==1){
            return new ResponseResult(200,"删除成功");
        }else{
            return new ResponseResult(500,"删除失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody Order order){
        int flag=orderManagerService.update(order);

        String username=order.getUsername();
        User user=userService.findByUserName(username);
        if(user==null){
            return new ResponseResult(500,"修改失败，该用户不存在");
        }

        String videoname=order.getVideoname();
        Video video=videoService.findByVideoName(videoname);
        if(video==null){
            return new ResponseResult(500,"修改失败，该视频不存在");
        }


        if(flag==1){
            return new ResponseResult(200,"修改成功");
        }else{
            return new ResponseResult(500,"修改失败");
        }
    }

}
