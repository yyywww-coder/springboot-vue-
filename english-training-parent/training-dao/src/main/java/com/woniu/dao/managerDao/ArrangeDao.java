package com.woniu.dao.managerDao;

import com.woniu.po.ArrangePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArrangeDao {

    //新增预约
    public void add(ArrangePo arrangePo);

    //模糊查询
    public List<ArrangePo> findByUsername(String username);

    //查询科目
    public List<ArrangePo> getCourse();

    //查询预约人数
    public List<Object> getNum();

    /**
     * 修改预约状态
     */
    public void updateArrange(@Param("status") String status, @Param("id") Integer id);
}
