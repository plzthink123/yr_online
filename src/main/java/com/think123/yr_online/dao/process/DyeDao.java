package com.think123.yr_online.dao.process;

import com.think123.yr_online.dto.ProcessDto;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-23 22:20
 */
public interface DyeDao {
    public List<Process> getAllDye(ProcessDto dto);

    void updateDye(ProcessDto dto);
}