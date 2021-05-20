package com.woniu.dao.managerDao;

import com.woniu.po.BannerPo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BannerDao {
    /**
     * 查找所有的Banner图
     */
    List<BannerPo> getAllBanner(String title);

    /**
     * 添加banner图
     * @param bannerPo
     */
    void saveBanner(BannerPo bannerPo);

    void removeById(String id);
}
