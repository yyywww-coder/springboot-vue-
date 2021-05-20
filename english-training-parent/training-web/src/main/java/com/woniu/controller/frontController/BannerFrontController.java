package com.woniu.controller.frontController;

import com.woniu.domain.Banner;
import com.woniu.service.frontService.BannerFrontService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("front/banner")
@CrossOrigin
public class BannerFrontController {
    @Autowired
    private BannerFrontService bannerFrontService;

    @RequestMapping("list")
    public ResponseResult<List<Banner>> getBanner(){
        List<Banner> banners =  bannerFrontService.getBanners();
        return new ResponseResult<>(banners);
    }
}
