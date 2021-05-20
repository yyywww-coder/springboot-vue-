package com.woniu.controller.frontController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Order;
import com.woniu.service.managerService.OrderManagerService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 前端评论功能
 */
@RestController
@CrossOrigin

@RequestMapping("front/order")
public class OrderFrontController {

    @Autowired
    private OrderManagerService orderManagerService;

    /**
     * 下订单功能
     */
    @RequestMapping("adds")
    public ResponseResult addOrder(HttpServletRequest request){
          Order order1=new Order();
        //用户id
        String token=request.getHeader("Authorization");
//        String username= JwtTokenUtil.getUserId(token);
        //视频id

        //支付时间
        Date date=new Date();
        order1.setOrderTime(date);
        //支付方式

        //订单是否删除标志,默认为1
        order1.setLog(1);

        int flag=orderManagerService.add(order1);
        if(flag==1){
            return new ResponseResult(200,"订单添加成功");
        }else{
            return new ResponseResult(500,"订单添加失败");
        }
    }
}
