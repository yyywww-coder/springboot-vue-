package com.woniu.dao.managerDao;

import com.woniu.po.PaperManagePo;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperManagerDao {

    Integer add(PaperManagePo paperManagePo);
}
