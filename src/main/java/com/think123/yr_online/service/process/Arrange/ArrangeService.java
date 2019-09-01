package com.think123.yr_online.service.process.Arrange;

import com.think123.yr_online.dto.ProcessDto;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-24 12:52
 */
public interface ArrangeService {
    Map<String, Object> getArrangePage(ProcessDto dto);


    public void modifyArrange(ProcessDto dto);

}
