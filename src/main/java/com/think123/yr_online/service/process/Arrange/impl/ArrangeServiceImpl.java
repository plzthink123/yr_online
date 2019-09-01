package com.think123.yr_online.service.process.Arrange.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.process.ArrangeDao;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.service.process.Arrange.ArrangeService;
import com.think123.yr_online.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-24 12:53
 */
@Service
public class ArrangeServiceImpl implements ArrangeService {
    @Autowired
    ArrangeDao arrangeDao;
    @Override
    public Map<String, Object> getArrangePage(ProcessDto dto) {
        PageInfo<Process> page = Utils.createPageInfo(dto, ()->{
            List<Process> list = arrangeDao.getAllArrange(dto);
            System.err.println(list);
            return list;
        });

        return Utils.convert2PageData(page);
    }

    @Override
    public void modifyArrange(ProcessDto dto) {
        arrangeDao.updateArrange(dto);

    }
}