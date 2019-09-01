package com.think123.yr_online.dataobject;

import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author plzthink123
 * 2019-08-07 12:03
 * 用户表
 */
@Data
@ToString
//@TableName("sys_user")
public class User {

    //用户id
    //@TableField("u_id")
    private String u_id;
    //用户名称
    //@TableField("u_name")
    private String u_name;
    //用户密码
    //@TableField("u_pwd")
    private String u_pwd;
    //用户状态
    //@TableField("u_status")
    private String u_status;

    private Set<Role> roles = new HashSet<>();
}