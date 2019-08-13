package com.think123.yr_online.service.safty.impl;

import com.think123.yr_online.dao.safty.UserDao;
import com.think123.yr_online.dataobject.Role;
import com.think123.yr_online.dataobject.User;
import com.think123.yr_online.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-12 23:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void getUserPage() {
        UserDto userDto=new UserDto();
        List<User> list = userDao.findUserList(userDto);
        for(User user:list){
            System.out.println(user);
        }
        System.out.println("===============");

    }

    @Test
    public void addUser() {
        UserDto userDto=new UserDto();
        userDto.setU_id("123");
        userDto.setU_name("test");
        userDto.setU_pwd("000");
        userDao.insert(userDto);
    }

    @Test
    public void modifyUser() {

    }

    @Test
    public void deleteUser() {


    }

    @Test
    public void getAllRole(){
        List<Role> allRole = userDao.getAllRole();
        for (Role role : allRole
             ) {
            System.out.println(role);
        }
    }

    @Test
    public void getOneUserRole(){
        List<Role> oneRole=userDao.getOneUserRole("admin");
        for (Role role : oneRole
        ) {
            System.out.println(role);
        }
    }
}