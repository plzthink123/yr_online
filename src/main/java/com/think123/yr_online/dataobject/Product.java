package com.think123.yr_online.dataobject;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author plzthink123
 * 2019-08-24 15:00
 */
@Data
public class Product {
    private BigDecimal product_id;

    private BigDecimal process_id;

    private String product_cus;

    private String product_std;

    private String product_color;

    private String product_level;

    private BigDecimal product_num;

    private String product_status;
}