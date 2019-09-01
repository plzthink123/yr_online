package com.think123.yr_online.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author plzthink123
 * 2019-08-24 15:00
 */
@Data
@Getter
@Setter
public class ProductDto extends  PageParam{
    private Integer product_id;

    private BigDecimal process_id;

    private String product_cus;

    private String product_std;

    private String product_color;

    private String product_level;

    private BigDecimal product_num;

    private String product_status;

    //
    private BigDecimal product_level1_num;

    private BigDecimal product_level2_num;

    private BigDecimal product_level3_num;

    private BigDecimal product_level4_num;

    private String checkPerson;

    private BigDecimal checkNum;

    private String check_date;
}