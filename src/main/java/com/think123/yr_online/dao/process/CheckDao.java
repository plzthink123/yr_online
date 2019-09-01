package com.think123.yr_online.dao.process;

import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.ProductDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author plzthink123
 * 2019-08-15 19:12
 */
public interface CheckDao {

    List<ProcessDto> findProcessList(ProcessDto dto);

    List<ProcessDto> findProcessPlanList(@Param("process_id") BigDecimal process_id);

    void addProcess(ProcessDto dto);

    @Select("select max(product_id) from bus_product")
    Integer findMaxId();

    void deleteProcess(@Param("process_id") BigDecimal id);

    void modifyProcess(ProcessDto dto);

    void modifyProcessStatus(ProcessDto dto);

    List<ProcessDto> findProcessListOnStatus5(ProcessDto dto);

    void addProduct(ProductDto dto);

    void updateStatus30(ProductDto dto);

     List<ProductDto> findProductList(ProductDto dto);

    void modifyProductStatusTo35(ProductDto dto);

    void modifyProcessStatusTo35(ProductDto dto);
}
