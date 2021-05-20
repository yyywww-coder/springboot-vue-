package com.woniu.service.managerService;

import com.woniu.domain.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {
    String uploadVideo(MultipartFile file);

    void saveVideo(Video video);

    String uploadPic(MultipartFile file);

    List<Video> getList(Video video);

    void removeById(String id);

    Video findByVideoName(String videoName);
}
