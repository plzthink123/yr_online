package com.think123.yr_online.dao.safty;

import com.think123.yr_online.dataobject.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeDao {

    public List<Module> findAllModules();

    public List<Module> findModulesByCurrUserId(String userId);

    public List<Module> findMobileModulesByCurrUserId(String userId);

}