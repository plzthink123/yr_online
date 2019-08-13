package com.think123.yr_online.dto;

import lombok.Data;

/**
 * @author plzthink123
 * 2019-08-07 12:05
 *  ro_id                int not null,
 *    ro_name              varchar(50) not null,
 *    ro_remark            varchar(200),
 *    ro_status
 *    角色表
 */
@Data
//@TableName("sys_role")
public class RoleDto  extends PageParam{
    //角色id
   // @TableField("ro_id")
    private Integer ro_id;

    //角色名称
    //@TableField("ro_name")
    private String ro_name;

    //
    //@TableField("ro_remark")
    private String ro_remark;

    //角色状态
   // @TableField("ro_status")
    private String ro_status;



}