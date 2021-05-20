package com.woniu.adapter.managerAdapter;

import com.woniu.dao.managerDao.PaperManagerDao;
import com.woniu.domain.PaperManage;
import com.woniu.po.PaperManagePo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaperManagerAdapter {
    @Autowired
    private PaperManagerDao paperManagerDao;

    public Integer add(PaperManage paperManage){
        PaperManagePo paperManagePo = new PaperManagePo();
        BeanUtils.copyProperties(paperManage,paperManagePo);
        Integer add = paperManagerDao.add(paperManagePo);
        return add;
    }

}
