package com.think123.yr_online.service.process.dye.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.process.DyeDao;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.service.process.dye.DyeService;
import com.think123.yr_online.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-23 22:20
 */
@Service
public class DyeServiceImpl implements DyeService {
    @Autowired
    DyeDao dyeDao;
    @Override
    public Map<String, Object> getDyePage(ProcessDto dto) {
        PageInfo<Process> page = Utils.createPageInfo(dto, ()->{
            List<Process> list = dyeDao.getAllDye(dto);
            System.err.println(list);
            return list;
        });

        return Utils.convert2PageData(page);
    }

    @Override
    public void modifyDye(ProcessDto dto) {
        dyeDao.updateDye(dto);
    }

}