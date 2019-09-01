package com.think123.yr_online.dao.safty;

import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dataobject.Role;
import com.think123.yr_online.dto.RoleDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper
public interface RoleDao {
    //@Select("select * from info_Role")
    List<Role> findRoleList(RoleDto dto);

    @Select("select max(ro_id) from sys_role")
    Integer findMaxId();

    @Insert("insert into sys_role values(#{ro_id},#{ro_name},#{ro_remark},'00')")
    void insert(RoleDto dto);

    @Update("update sys_role set ro_name=#{ro_name} , ro_remark=#{ro_remark} ,ro_status=#{ro_status} where ro_id=#{ro_id}")
    void update(RoleDto dto);

    void delete(Integer[] ids);

    List<Module> findAllModule();

    List<Module> findOneRoleModule(@Param("ro_id") Integer ro_id);

    void addModule(@Param("m_id") Integer m_id, @Param("ro_id") Integer ro_id);

    void deleteModule(@Param("m_id") Integer m_id, @Param("ro_id") Integer ro_id);
}
