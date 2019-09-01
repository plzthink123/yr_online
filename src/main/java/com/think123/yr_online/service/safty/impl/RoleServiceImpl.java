package com.think123.yr_online.service.safty.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.safty.RoleDao;
import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dataobject.Role;
import com.think123.yr_online.dto.RoleDto;
import com.think123.yr_online.service.safty.RoleService;
import com.think123.yr_online.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
@Service
@Slf4j
@Transactional
public class RoleServiceImpl implements RoleService {

    private Integer id;

    @Autowired
    private RoleDao roleDao;

    @PostConstruct//初始化方法注解
    public void init() {
        id = roleDao.findMaxId();
    }

    private synchronized Integer getNewId() {
        return ++id;
    }

    @Override
    public Map<String, Object> getRolePage(RoleDto dto) {

        PageInfo<Role> page = Utils.createPageInfo(dto, () -> {

            return roleDao.findRoleList(dto);
        });
        return Utils.convert2PageData(page);

    }

    @Override
    public void addRole(RoleDto dto) {

        //获得新编号
        dto.setRo_id(getNewId());
        roleDao.insert(dto);

    }

    @Override
    public void modifyRole(RoleDto dto) {
        roleDao.update(dto);

    }

    @Override
    public void deleteRole(Integer[] ids) {
        roleDao.delete(ids);

    }

    @Override
    public List<Module> findAllModule() {
        return roleDao.findAllModule();
    }

    @Override
    public List<Module> findOneRoleModule(Integer ro_id) {
        return roleDao.findOneRoleModule(ro_id);
    }

    @Override
    public void addModule(Integer[] movekeys, Integer ro_id) {
        for (int i = 0; i < movekeys.length; i++) {
            roleDao.addModule(movekeys[i], ro_id);
        }
    }

    @Override
    public void deleteRole(Integer[] movekeys, Integer ro_id) {
        for (int i = 0; i < movekeys.length; i++) {
            roleDao.deleteModule(movekeys[i], ro_id);
        }
    }
}