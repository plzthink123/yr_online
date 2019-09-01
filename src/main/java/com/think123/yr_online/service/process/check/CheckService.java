package com.think123.yr_online.service.process.check;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-24 13:27
 */
public interface CheckService {
    Map<String, Object> getProcessPage(ProcessDto dto);

    List<ProcessDto> getPlanPage(BigDecimal plan_id);

   /* void addProcess(ProcessDto dto);*/

    void deleteProcess(BigDecimal[] ids);

    void modifyProcess(ProcessDto dto);

    void modifyProcessStatus(ProcessDto dto);

    Map<String, Object> getProcessPageOnStatus5(ProcessDto dto);


    void addProduct(ProductDto dto, List<BigDecimal> list);

    void updateStatus(ProductDto dto);

    Map<String, Object> getCheckPage(ProductDto dto);

    void modifyProcessStatusTo35(ProductDto dto, BigDecimal sum, CurrUser currUser);

    void modifyProductStatusTo35(ProductDto dto);
}
