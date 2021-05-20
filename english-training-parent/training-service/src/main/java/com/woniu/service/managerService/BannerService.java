package com.woniu.service.managerService;

import com.woniu.domain.Banner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {
    List<Banner> getAllBanner(String bannerQuery);

    String uploadBanner(MultipartFile file);

    void saveBanner(Banner banner);

    void removeById(String id);
}
