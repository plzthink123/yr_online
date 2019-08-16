package com.think123.yr_online.service.process.pretreatment;

import com.think123.yr_online.dto.ProcessDto;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-16 17:00
 */
public interface PretreatmentService {
    Map<String, Object> getProcessPageOnStatus5(ProcessDto dto);

    void modifyProcess(ProcessDto dto);
}