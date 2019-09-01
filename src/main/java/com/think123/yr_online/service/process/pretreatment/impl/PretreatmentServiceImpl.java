package com.think123.yr_online.service.process.pretreatment.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.process.PretreatmentDao;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.service.process.pretreatment.PretreatmentService;
import com.think123.yr_online.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-16 17:00
 */
@Service
public class PretreatmentServiceImpl implements PretreatmentService {
    @Autowired
    private PretreatmentDao pretreatmentDao;

    @Override
    public Map<String, Object> getProcessPageOnStatus5(ProcessDto dto) {
        PageInfo<ProcessDto> page = Utils.createPageInfo(dto, () -> {

            return pretreatmentDao.findProcessListOnStatus5(dto);
        });
        return Utils.convert2PageData(page);
    }

    @Override
    public void modifyProcess(ProcessDto dto) {
        pretreatmentDao.modifyProcess(dto);
    }
}