package com.woniu.dao.managerDao;

import com.woniu.po.VideoPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoDao {
    public void saveVideo(VideoPo videoPo);

    List<VideoPo> getList(VideoPo videoPo);

    void removeVideoById(String id);


    VideoPo findByVideoName(String videoName);
}
