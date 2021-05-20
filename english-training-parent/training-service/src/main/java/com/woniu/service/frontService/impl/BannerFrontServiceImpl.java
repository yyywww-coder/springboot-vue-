package com.woniu.service.frontService.impl;

import com.woniu.adapter.frontAdapter.BannerFrontAdapter;
import com.woniu.adapter.managerAdapter.BannerAdapter;
import com.woniu.domain.Banner;
import com.woniu.service.frontService.BannerFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BannerFrontServiceImpl implements BannerFrontService {
    @Autowired
    private BannerFrontAdapter bannerFrontAdapter;
    @Override
    public List<Banner> getBanners() {
        List<Banner> banners = bannerFrontAdapter.getBanners();

        return banners;
    }
}
