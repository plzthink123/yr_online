package com.think123.yr_online.service.process.Print;

import com.think123.yr_online.dto.ProcessDto;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-24 12:31
 */

public interface PrintService {
    Map<String, Object> getPrintPage(ProcessDto dto);

    void modifyPrint(ProcessDto dto);
}
