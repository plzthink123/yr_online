package com.think123.yr_online.dao.process;

import com.think123.yr_online.dto.ProcessDto;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-24 12:51
 */
public interface ArrangeDao {

    List<Process> getAllArrange(ProcessDto dto);

    void updateArrange(ProcessDto dto);

}