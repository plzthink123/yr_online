package com.think123.yr_online.service.safty.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.safty.UserDao;
import com.think123.yr_online.dataobject.Role;
import com.think123.yr_online.dataobject.User;
import com.think123.yr_online.dto.UserDto;
import com.think123.yr_online.service.safty.UserService;
import com.think123.yr_online.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao UserDao;





    @Override
    public Map<String, Object> getUserPage(UserDto dto) {

        PageInfo<User> page = Utils.createPageInfo(dto, ()->{

            return UserDao.findUserList(dto);
        });
        return Utils.convert2PageData(page);



    }

    @Override
    public void addUser(UserDto dto) {

        //获得新编号
        UserDao.insert(dto);


    }

    @Override
    public void modifyUser(UserDto dto) {
        UserDao.update(dto);

    }

    @Override
    public void deleteUser(String[] ids) {
        UserDao.delete(ids);

    }

    @Override
    public List<Role> getAllRole() {
        return UserDao.getAllRole();
    }

    @Override
    public List<Role> getOneUserRole(String u_id) {
        return UserDao.getOneUserRole(u_id);
    }

    @Override
    public void addRole(Integer[] movekeys,String u_id) {
        for(int i=0;i <movekeys.length;i++){
            UserDao.addRole(movekeys[i], u_id);
        }
    }

    @Override
    public void deleteRole(Integer[] movekeys, String u_id) {
        for(int i=0;i <movekeys.length;i++){
            UserDao.deleteRole(movekeys[i], u_id);
        }
    }

    @Override
    public User findByUsername(String username) {
        return UserDao.findByUserName(username);
    }

    @Override
    public List<Role> selectRoleByUserId(String u_id) {
        return UserDao.findRoleByUserId(u_id);
    }

    @Override
    public String findOldPasswordById(String u_id) {
        return UserDao.findOldPasswordById(u_id);
    }

    @Override
    public void changePasswordById(String u_id, String pwd) {
        UserDao.changePasswordById(u_id,pwd);
    }

}