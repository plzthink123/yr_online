package com.think123.yr_online.dto;

import lombok.Data;

/**
 * @author plzthink123
 * 2019-08-09 17:04
 */
@Data
public class StandardDto extends PageParam {
    private Integer standard_id;

    private String standard_name;

    private String standard_remark;

    private String standard_status;
}