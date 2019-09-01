package com.think123.yr_online.service.process.check.impl;

import com.think123.yr_online.dao.process.CheckDao;
import com.think123.yr_online.dto.ProcessDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author plzthink123
 * 2019-08-24 14:07
 */
public class CheckServiceImplTest {
    @Autowired
    private CheckDao checkDao;

    @Test
    public void getPlanPage() {
        List<ProcessDto> planList = checkDao.findProcessPlanList(new BigDecimal(3));
        for( ProcessDto processDto:planList){
            System.out.println(processDto);
        }
    }
}