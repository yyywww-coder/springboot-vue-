package com.woniu.controller.managerController;


import com.github.pagehelper.PageInfo;
import com.woniu.domain.Arrange;
import com.woniu.po.ArrangePo;
import com.woniu.service.managerService.ArrangeService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("arrange")
@SuppressWarnings("all")
public class ArrangeController {

    @Autowired
    private ArrangeService arrangeService;

    /**
     * 所有
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult<PageInfo<Arrange>> list(Integer pageIndex, Integer pageSize, String searchText){
        if (searchText != null){
            PageInfo<ArrangePo> poPageInfo = arrangeService.findByUsername(pageIndex,pageSize,searchText);
            PageInfo<Arrange> pageInfo = new PageInfo<>();
            BeanUtils.copyProperties(poPageInfo,pageInfo);
            return new ResponseResult<>(pageInfo);
        }

        return null;
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("/update")
    public ResponseResult updateArrange(String status, Integer id){

        arrangeService.updateArrange(status,id);
        System.out.println(status+"```````````````"+id);
        return new ResponseResult(200,"修改成功");
    }



}
