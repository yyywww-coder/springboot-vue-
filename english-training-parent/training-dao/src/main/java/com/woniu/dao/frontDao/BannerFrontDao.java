package com.woniu.dao.frontDao;

import com.woniu.po.BannerPo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BannerFrontDao {
    List<BannerPo> getBanners();
}
