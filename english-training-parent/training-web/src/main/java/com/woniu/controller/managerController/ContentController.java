package com.woniu.controller.managerController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Content;
import com.woniu.po.ContentPo;
import com.woniu.service.managerService.ContentService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/list")
    public ResponseResult<PageInfo<Content>> list(Integer pageIndex, Integer pageSize){

            PageInfo<ContentPo> poPageInfo = contentService.findAll(pageIndex,pageSize);
            PageInfo<Content> pageInfo = new PageInfo<>();
            BeanUtils.copyProperties(poPageInfo,pageInfo);
            return new ResponseResult<>(pageInfo);

    }
}
