package com.woniu.controller.frontController;

import com.woniu.domain.Links;
import com.woniu.service.frontService.LinkFrontService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("front/link")
public class LinkFrontController {


        @Autowired
        private LinkFrontService linkFrontService;


        /**
         * 所有视频分页数据
         * @return
         */
        @RequestMapping("list")
        public ResponseResult<List<Links>> list(){
                List<Links> allLink = linkFrontService.getAllLink();

                return new ResponseResult<>(allLink);

        }
}
