package com.think123.yr_online.dataobject;

import lombok.Data;

/**
 * @author plzthink123
 * 2019-08-07 12:08
 * 权限角色关联表
 *  m_id
 *    ro_id
 */
@Data
//@TableName("sys_rm")
public class RM {

    //权限id
    //@TableField("m_id")
    private Integer mid;

    //角色id
    //@TableField("ro_id")
    private Integer roid;

}