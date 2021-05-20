package com.woniu.controller.managerController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.domain.Banner;
import com.woniu.service.managerService.BannerService;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("list")
    public ResponseResult<PageInfo<Banner>> getAll(Integer page,Integer limit,String bannerQuery){
        PageHelper.startPage(page,limit);
        List<Banner> banners = bannerService.getAllBanner(bannerQuery);
        PageInfo<Banner> pageInfo = new PageInfo<>(banners);
        return new ResponseResult<>(pageInfo);
    }


    @PostMapping("add")
    public ResponseResult<String> addBanner(MultipartFile file){
        String uploadUrl = bannerService.uploadBanner(file);
        return new ResponseResult<>(uploadUrl);
    }

    @PostMapping("save")
    public ResponseResult<Void> saveBanner(@RequestBody Banner banner){
        banner.setGmtCreate(new Date());
        bannerService.saveBanner(banner);
        return ResponseResult.SUCCESS;
    }

    //删除Banner
    @RequestMapping("remove/{id}")
    public ResponseResult remove(@PathVariable String id) {
        bannerService.removeById(id);
        return ResponseResult.SUCCESS;
    }
}
