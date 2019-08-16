package com.think123.yr_online.service.process.rawcloth;

import com.think123.yr_online.dto.ProcessDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-15 18:56
 */
public interface RawclothService {


    Map<String, Object> getProcessPage(ProcessDto dto);

    List<ProcessDto> getPlanPage(Integer plan_id);

    void addProcess(ProcessDto dto);

    void deleteProcess(BigDecimal[] ids);

    void modifyProcess(ProcessDto dto);

    void modifyProcessStatus(ProcessDto dto);

    Map<String, Object> getProcessPageOnStatus5(ProcessDto dto);
}
