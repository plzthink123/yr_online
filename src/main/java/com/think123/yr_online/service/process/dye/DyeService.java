package com.think123.yr_online.service.process.dye;

import com.think123.yr_online.dto.ProcessDto;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-23 22:20
 */
public interface DyeService {
    Map<String, Object> getDyePage(ProcessDto dto);

    void modifyDye(ProcessDto dto);
}
