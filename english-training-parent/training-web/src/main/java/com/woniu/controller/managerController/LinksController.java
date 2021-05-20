package com.woniu.controller.managerController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.po.LinksPo;
import com.woniu.service.managerService.LinksService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/links/")
public class LinksController {

        @Autowired
        private LinksService linksService;

        /**
         * 链接分页
         * @return
         */
        @RequestMapping("list")
        public ResponseResult<PageInfo<LinksPo>> list(Integer pageIndex, Integer pageSize){
                PageHelper.startPage(pageIndex,pageSize);
                List<LinksPo> allLinks = linksService.findAllLinks();
                PageInfo<LinksPo> pageInfo = new PageInfo<>(allLinks);
                return new ResponseResult(pageInfo);
        }

        /**
         * 修改链接
         * @return
         */
        @RequestMapping("update")
        public ResponseResult update(@RequestBody LinksPo linksPo){
                linksService.update(linksPo);
                return ResponseResult.SUCCESS;
        }

        /**
         * 根据id删除
         * @param id
         * @return
         */
        @RequestMapping("delete")
        public ResponseResult delete(Integer id){
                linksService.delete(id);
                return ResponseResult.SUCCESS;
        }

        /**
         * 新增链接
         * @return
         */
        @RequestMapping("add")
        public ResponseResult add(@RequestBody LinksPo linksPo){
                linksService.add(linksPo);
                return ResponseResult.SUCCESS;
        }
}
