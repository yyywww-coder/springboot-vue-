package com.woniu.controller.frontController;

import com.github.pagehelper.PageInfo;
import com.woniu.domain.Video;
import com.woniu.po.VideoPo;
import com.woniu.service.frontService.VideoFrontService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("front/video")
public class VideoFrontController {


        @Autowired
        private VideoFrontService videoFrontService;


        /**
         * 所有视频分页数据
         * @param pageIndex
         * @param pageSize
         * @return
         */
        @RequestMapping("list")
        public ResponseResult<PageInfo<Video>> list(Integer pageIndex,Integer pageSize,String status,String sorts,String moneyy){

                VideoPo videoPo = new VideoPo();
                videoPo.setStatus(status);
                if(sorts !=null && !sorts.equals("")){

                        videoPo.setCreateTime(new Date());
                }

                if(moneyy !=null && !moneyy.equals("")){
                        videoPo.setPrice(100.0);
                }

                PageInfo<VideoPo> poPageInfo = videoFrontService.getAllVideos(pageIndex,pageSize,videoPo);
                PageInfo<Video> pageInfo = new PageInfo<>();
                BeanUtils.copyProperties(poPageInfo,pageInfo);

                return new ResponseResult(pageInfo);

        }
}
