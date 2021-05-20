package com.woniu.service.managerService.impl;

import com.woniu.adapter.managerAdapter.PermsAdapter;
import com.woniu.dao.managerDao.PermsDao;
import com.woniu.domain.Perms;
import com.woniu.po.PermsPo;
import com.woniu.service.managerService.ManagerService;
import com.woniu.service.managerService.PermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PermsServiceImpl implements PermsService {

        @Autowired
        private PermsDao permsDao;

        @Autowired
        private PermsAdapter permsPoAdapter;
        @Autowired
        private ManagerService managerService;


        @Override
        public void delPermsById(Integer id) {
                permsDao.delById(id);
        }


        @Override
        public List<Perms> getById(Integer id) {
                return permsPoAdapter.getById(id);
        }

        @Override
        public void addPerms(Map<String, Integer> maps,Integer id) {
                permsPoAdapter.addPerms(maps,id);
        }

        @Override
        public List<PermsPo> findAllPerms() {
                return permsDao.findAllPerms();
        }

        @Override
        public List<Perms> findPermByUsername(String account) {
                return permsPoAdapter.findPermByUsername(account);
        }


        @Override
        public List<String> findPermsByUsername(String username) {
                return permsPoAdapter.findPermsByUsername(username);
        }
}
