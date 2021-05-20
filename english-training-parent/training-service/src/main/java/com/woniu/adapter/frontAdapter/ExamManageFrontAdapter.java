package com.woniu.adapter.frontAdapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.dao.frontDao.ExamManageFrontDao;
import com.woniu.domain.ExamManage;
import com.woniu.po.ExamManagePo;
import com.woniu.po.ManagerPo;
import com.woniu.redis.frontRedisDao.ExamManageFrontRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManageFrontAdapter {

    @Autowired
    private ExamManageFrontDao examManageFrontDao;

    @Autowired
    private ExamManageFrontRedisDao examManageFrontRedisDao;

    PageInfo<ExamManagePo> poPageInfo = null;

    /**
     * 模糊查询
     * @param pageIndex
     * @param pageSize
     * @param source
     * @return
     */
    public PageInfo<ExamManagePo> findExamBySource(Integer pageIndex,Integer pageSize,String source){
        List<ExamManagePo> examManagePoList = examManageFrontRedisDao.list();
        if (examManagePoList.size() == 0){
            PageHelper.startPage(pageIndex,pageSize);
            examManagePoList = examManageFrontDao.findExamByCode(source);
            poPageInfo = new PageInfo<>(examManagePoList);
            examManageFrontRedisDao.addRedisExamList(poPageInfo);
        }
        poPageInfo = new PageInfo<>(examManagePoList);
        return poPageInfo;
    }

    public ExamManagePo findByExamCode(Integer examCode){
        return examManageFrontDao.findByExamCode(examCode);
    }

}
