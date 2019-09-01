package com.think123.yr_online.dao.safty;

import com.think123.yr_online.dataobject.Role;
import com.think123.yr_online.dataobject.User;
import com.think123.yr_online.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface UserDao {
    //@Select("select * from info_User")
    List<User> findUserList(UserDto dto);

    @Insert("insert into sys_user values(#{u_id},#{u_pwd},#{u_name},'00')")
    void insert(UserDto dto);

    //@Update("update sys_user set u_name=#{u_name} ,u_pwd=#{u_pwd} ,u_status=#{u_status} where u_id=#{u_id}")
    void update(UserDto dto);

    void delete(String[] ids);

    List<Role> getAllRole();

    List<Role> getOneUserRole(String u_id);

    void addRole(@Param("ro_id") Integer ro_id, @Param("u_id") String u_id);

    void deleteRole(@Param("ro_id") Integer ro_id, @Param("u_id") String u_id);

    User findByUserName(@Param("u_name") String u_name);

    List<Role> findRoleByUserId(@Param("u_id") String u_id);

    String findOldPasswordById(@Param("u_id") String u_id);

    void changePasswordById(@Param("u_id") String u_id, @Param("u_pwd") String pwd);
}
