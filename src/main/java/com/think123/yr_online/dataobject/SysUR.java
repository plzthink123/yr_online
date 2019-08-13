package com.think123.yr_online.dataobject;

import lombok.Data;

/**
 * @author plzthink123
 * 2019-08-07 12:05
 * 用户角色关联表
 */
@Data
//@TableName("sys_ur")
public class SysUR {
    //用户id
    //@TableField("u_id")
    private String uid;

    //角色id
    //@TableField("ro_id")
    private Integer roid;
}