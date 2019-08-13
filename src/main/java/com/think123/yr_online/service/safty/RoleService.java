package com.think123.yr_online.service.safty;

import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dto.RoleDto;

import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
public interface RoleService {
    Map<String, Object> getRolePage(RoleDto dto);

    void addRole(RoleDto dto);

    void modifyRole(RoleDto dto);

    void deleteRole(Integer[] ids);

    List<Module> findAllModule();
    List<Module> findOneRoleModule(Integer ro_id);

    void addModule(Integer[] movekeys,Integer ro_id);

    void deleteRole(Integer[] movekeys,Integer ro_id);
}
