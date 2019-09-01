package com.think123.yr_online.dataobject;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author plzthink123
 * 2019-08-15 19:00
 */
@Data
public class Process {
    private BigDecimal process_id;

    private Integer plan_id;

    private String process_cus;

    private String process_std;

    private String process_color;
    //布匹数量
    private BigDecimal group_num;
    //分组投坯时间
    private String group_date;

    private String group_person;

    private BigDecimal pretreat_num;

    private String pretreat_date;

    private String pretrea_person;

    private BigDecimal dye_num;

    private String dye_date;

    private String dye_person;

    private BigDecimal print_num;

    private String print_date;

    private String print_person;

    private BigDecimal arrange_num;

    private String arrange_date;

    private String arrange_person;

    private BigDecimal check_num;

    private String check_date;

    private String check_person;
    //            00 未投坯
//            05 已投坯
//            10 已前处理
//            15 已染色
//            20 已印花
//            25 已整理
//            30 质检中
//            35 已质检
//            40 包装中
//            50 已包装
//            55 已部分入库
//            60 已入库
//            65 已部分交货
//            70 已交货
    private String process_status;

}