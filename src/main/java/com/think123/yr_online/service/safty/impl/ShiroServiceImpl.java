package com.think123.yr_online.service.safty.impl;

import com.think123.yr_online.dao.safty.ShiroDao;
import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dataobject.User;
import com.think123.yr_online.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-14 10:19
 */
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private ShiroDao shiroDao;
    @Override
    public List<Module> getAllSubModules() {
        return shiroDao.getAllSubModules();
    }

    @Override
    public User getUser(String userId) {
        return shiroDao.getUser(userId);
    }

    @Override
    public List<Module> getModulesOfUser(String userId) {
        return shiroDao.getModulesOfUser(userId);
    }

}