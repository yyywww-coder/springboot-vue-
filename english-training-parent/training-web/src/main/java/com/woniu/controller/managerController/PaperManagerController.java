package com.woniu.controller.managerController;

import com.woniu.domain.PaperManage;
import com.woniu.service.managerService.PaperManagerService;
import com.woniu.utils.ResponseResult;
import com.woniu.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("paper")
public class PaperManagerController {
    @Autowired
    private PaperManagerService paperManagerService;
    @RequestMapping("add")
    public ResponseResult addPaper(@RequestBody PaperManage paperManage){
        Integer add = paperManagerService.add(paperManage);
        if(add!=null){
            return ResponseResult.SUCCESS;
        }
        return new ResponseResult(403,"添加失败");
    }
}
