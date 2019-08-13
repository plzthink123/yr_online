package com.think123.yr_online.dto;

import lombok.Data;

/**
 * @author plzthink123
 * 2019-08-09 14:04
 */
@Data
public class ColorDto  extends  PageParam{
    private Integer co_id;

    private String co_name;

    private String co_remark;

    private String co_status;


}