package com.think123.yr_online.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author plzthink123
 * 2019-08-14 19:51
 * 进度计划表
 */
@Data
@ToString
public class PlanDto  extends PageParam{
    //计划单id
    private Integer plan_id;
    //标准id
    private Integer standard_id;
    //客户id
    private Integer cus_id;
    //颜色id
    private Integer co_id;
    //生产顺序
    private Integer plan_xh;
    //计划月份
    @JsonFormat(pattern = "yyyy-MM")
    @DateTimeFormat(pattern="yyyy-MM")
    private String plan_month;
    //计划产量
    private BigDecimal plan_num;
    //计划类型
    private Integer plan_type;
    //计划下达日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date plan_date;
    //计划登记人
    private String plan_person;
    //计划状态
    private Integer plan_status;
    private String cus_name;

    private String co_name;

    private String standard_name;

}