package com.woniu.adapter.managerAdapter;

import com.woniu.dao.managerDao.BannerDao;
import com.woniu.domain.Banner;
import com.woniu.po.BannerPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BannerAdapter {
    @Autowired
    private BannerDao bannerDao;

    /**
     * 查询banner图
     * @return
     */
    public List<Banner> getAllBanner(String bannerQuery){
        List<BannerPo> bannerPos = bannerDao.getAllBanner(bannerQuery);
        List<Banner> banners = new ArrayList<>();
        for (BannerPo bannerPo : bannerPos) {
            Banner banner = new Banner();
            BeanUtils.copyProperties(bannerPo,banner);
            banners.add(banner);
        }
        return banners;
    }

    /**
     * 添加banner图
     * @param banner
     */
    public void saveBanner(Banner banner) {
        BannerPo bannerPo = new BannerPo();
        BeanUtils.copyProperties(banner,bannerPo);
        bannerDao.saveBanner(bannerPo);
    }

    public void removeById(String id) {
        bannerDao.removeById(id);
    }
}
