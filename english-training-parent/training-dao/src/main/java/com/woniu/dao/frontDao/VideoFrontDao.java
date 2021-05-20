package com.woniu.dao.frontDao;

import com.woniu.po.VideoPo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 前台视频
 */
@Component
public interface VideoFrontDao {

        // 查询所有视频
        public List<VideoPo> getAllVideo(VideoPo videoPo);



}
