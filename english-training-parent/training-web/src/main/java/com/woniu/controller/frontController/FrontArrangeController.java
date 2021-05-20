package com.woniu.controller.frontController;

import com.woniu.po.ArrangePo;
import com.woniu.service.managerService.ArrangeService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("front/arrange")
public class FrontArrangeController {


    @Autowired
    private ArrangeService arrangeService;

    @RequestMapping("add")
    public ResponseResult add(@RequestBody ArrangePo arrangePo){
        arrangePo.setStatus("0");

        arrangePo.setOrderTime(new Date());

        arrangeService.addArrange(arrangePo);
        return ResponseResult.SUCCESS;

    }


}
