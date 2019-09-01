package com.think123.yr_online.service.process.Print;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.process.PrintDao;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-24 12:32
 */
@Service
public class PrintServiceImpl implements PrintService {

    @Autowired
    private PrintDao printDao;
    @Override
    public Map<String, Object> getPrintPage(ProcessDto dto) {
        PageInfo<Process> page = Utils.createPageInfo(dto, ()->{
            List<Process> list = printDao.getAllPrint(dto);
            System.err.println(list);
            return list;
        });

        return Utils.convert2PageData(page);
    }

    @Override
    public void modifyPrint(ProcessDto dto) {
        printDao.updatePrint(dto);
    }
}