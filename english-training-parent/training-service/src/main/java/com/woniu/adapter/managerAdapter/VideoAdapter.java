package com.woniu.adapter.managerAdapter;

import com.woniu.dao.managerDao.VideoDao;
import com.woniu.domain.Video;
import com.woniu.po.VideoPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VideoAdapter {
    @Autowired
    private VideoDao videoDao;

    public void saveVideo(Video video){
        VideoPo videoPo = new VideoPo();
        BeanUtils.copyProperties(video,videoPo);
        videoDao.saveVideo(videoPo);
    }

    public List<Video> getList(Video video) {
        VideoPo videoPo = new VideoPo();
        BeanUtils.copyProperties(video,videoPo);
        List<VideoPo> videoPos = videoDao.getList(videoPo);
        List<Video> videos = new ArrayList<>();
        for (VideoPo po : videoPos) {
            Video video1 = new Video();
            BeanUtils.copyProperties(po,video1);
            videos.add(video1);
        }
        return videos;
    }

    /**
     * 删除视频
     * @param id
     */
    public void removeById(String id){
        videoDao.removeVideoById(id);
    }

    public Video findByVideoName(String videoName) {
        VideoPo videoPo = new VideoPo();
        videoPo=videoDao.findByVideoName(videoName);
        Video video=new Video();
        if(videoPo==null){
            return null;
        }
        else{ BeanUtils.copyProperties(videoPo, video);}
        return video;
    }
}
