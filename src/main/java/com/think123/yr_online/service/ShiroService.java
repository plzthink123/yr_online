package com.think123.yr_online.service;

import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dataobject.User;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-14 10:18
 */
public interface ShiroService {

    List<Module> getAllSubModules();

    User getUser(String userId);

    List<Module> getModulesOfUser(String userId);
}
