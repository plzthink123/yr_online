package com.think123.yr_online.dao.process;

import com.think123.yr_online.dto.ProcessDto;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-24 12:34
 */
public interface PrintDao {
    List<Process> getAllPrint(ProcessDto dto);

    void updatePrint(ProcessDto dto);
}