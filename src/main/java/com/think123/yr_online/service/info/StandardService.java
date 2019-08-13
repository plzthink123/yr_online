package com.think123.yr_online.service.info;

import com.think123.yr_online.dto.StandardDto;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
public interface StandardService {
    Map<String, Object> getStandardPage(StandardDto dto);

    void addStandard(StandardDto dto);

    void modifyStandard(StandardDto dto);

    void deleteStandard(Integer[] ids);
}
