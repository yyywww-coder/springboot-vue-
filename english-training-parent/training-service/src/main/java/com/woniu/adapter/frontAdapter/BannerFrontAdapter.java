package com.woniu.adapter.frontAdapter;

import com.woniu.dao.frontDao.BannerFrontDao;
import com.woniu.domain.Banner;
import com.woniu.po.BannerPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BannerFrontAdapter {
    @Autowired
    private BannerFrontDao bannerFrontDao;

    public List<Banner> getBanners(){
        List<BannerPo> banners = bannerFrontDao.getBanners();
        List<Banner> bannerList = new ArrayList<>();
        for (BannerPo banner : banners) {
            Banner banner1 = new Banner();
            BeanUtils.copyProperties(banner,banner1);
            bannerList.add(banner1);
        }
        return bannerList;
    }
}
