package com.think123.yr_online.dataobject;

import lombok.Data;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-07 12:09
 * 权限表
 *  m_id                 int not null comment '模块编号规则：一级模块编号为两位，二级模块编号为一级模块编号+两位编号，三级模块编号为二级模块编号+两位编号，以此类推。',
 *    m_pid                int comment '模块编号规则：一级模块编号为两位，二级模块编号为一级模块编号+两位编号，三级模块编号为二级模块编号+两位编号，以此类推。',
 *    m_name               varchar(20) not null comment '模块名称',
 *    m_url                varchar(100) comment '模块首地址',
 *    m_ismenu             smallint not null,
 *    m_status
 */
@Data
//@TableName("sys_module")
public class SysModule {

    //模块id
   // @TableField("m_id")
    private Integer mid;

    //父模块id
   // @TableField("p_id")
    private String pid;

    //模块名称
   // @TableField("m_name")
    private String mName;

    //模块地址:
   // @TableField("m_url")
    private String mUrl;

    //是否为菜单
   // @TableField("m_ismenu")
    private  Integer mIsMenu;

    //模块状态
   // @TableField("m_status")
    private  String mStatus;

    private List<Role> roles;

}