package com.think123.yr_online.dao.process;

import com.think123.yr_online.dto.ProcessDto;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-15 19:12
 */
public interface PretreatmentDao {



     List<ProcessDto> findProcessListOnStatus5(ProcessDto dto);

    void modifyProcess(ProcessDto dto);
}
