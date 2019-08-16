package com.think123.yr_online.dao.process;

import com.think123.yr_online.dto.ProcessDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author plzthink123
 * 2019-08-15 19:12
 */
public interface RawclothDao {

     List<ProcessDto> findProcessList(ProcessDto dto);

      List<ProcessDto> findProcessPlanList(@Param("plan_id") Integer plan_id);

    void addProcess(ProcessDto dto);
    @Select("select max(process_id) from bus_process")
    BigDecimal findMaxId();

    void deleteProcess(@Param("process_id") BigDecimal id);

    void modifyProcess(ProcessDto dto);

    void modifyProcessStatus(ProcessDto dto);

     List<ProcessDto> findProcessListOnStatus5(ProcessDto dto);
}
