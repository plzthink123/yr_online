package com.think123.yr_online.service.safty;

import com.think123.yr_online.dataobject.Role;
import com.think123.yr_online.dataobject.User;
import com.think123.yr_online.dto.UserDto;

import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
public interface UserService {
    Map<String, Object> getUserPage(UserDto dto);

    void addUser(UserDto dto);

    void modifyUser(UserDto dto);

    void deleteUser(String[] ids);

    List<Role> getAllRole();

    List<Role> getOneUserRole(String u_id);

    void addRole(Integer[] movekeys,String u_id);

    void deleteRole(Integer[] movekeys,String u_id);

    User findByUsername(String username);

    List<Role> selectRoleByUserId(String u_id);

    String findOldPasswordById(String u_id);

    void changePasswordById(String u_id, String pwd);
}
