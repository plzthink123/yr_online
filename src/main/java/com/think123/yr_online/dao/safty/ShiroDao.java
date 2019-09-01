package com.think123.yr_online.dao.safty;

import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dataobject.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-14 10:22
 */
public interface ShiroDao {
    List<Module> getAllSubModules();

    User getUser(@Param("u_id") String userId);

    List<Module> getModulesOfUser(@Param("u_id") String userId);
}
