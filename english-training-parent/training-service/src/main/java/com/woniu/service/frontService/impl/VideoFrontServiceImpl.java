package com.woniu.service.frontService.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.frontAdapter.VideoFrontAdapter;
import com.woniu.exception.VideoException;
import com.woniu.po.VideoPo;
import com.woniu.service.frontService.VideoFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VideoFrontServiceImpl implements VideoFrontService {

        @Autowired
        private VideoFrontAdapter videoFrontAdapter;


        /**
         * 查询所有视频
         * @param pageIndex
         * @param pageSize
         * @return
         */
        @Override
        public PageInfo<VideoPo> getAllVideos(Integer pageIndex, Integer pageSize,VideoPo videoPo) {

                PageInfo<VideoPo> pageInfo = videoFrontAdapter.findVideoLists(pageIndex, pageSize,videoPo);
                if(pageInfo ==null){
                        throw new VideoException("无相关数据");
                }else{
                        return pageInfo;
                }
        }
}
