package com.woniu.service.frontService;

import com.github.pagehelper.PageInfo;
import com.woniu.po.VideoPo;

public interface VideoFrontService {

        // 查找全部视频
        public PageInfo<VideoPo> getAllVideos(Integer pageIndex, Integer pageSize,VideoPo videoPo);
}
