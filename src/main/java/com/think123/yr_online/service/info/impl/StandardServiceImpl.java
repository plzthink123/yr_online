package com.think123.yr_online.service.info.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.info.StandardDao;
import com.think123.yr_online.dataobject.Standard;
import com.think123.yr_online.dto.StandardDto;
import com.think123.yr_online.service.info.StandardService;
import com.think123.yr_online.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
@Service
@Slf4j
@Transactional
public class StandardServiceImpl implements StandardService {

    private Integer id;

    @Autowired
    private StandardDao standardDao;


    @PostConstruct//初始化方法注解
    public void init() {
        id=standardDao.findMaxId();
    }

    private synchronized Integer  getNewId() {
        return  ++id;
    }

    @Override
    public Map<String, Object> getStandardPage(StandardDto dto) {

        PageInfo<Standard> page = Utils.createPageInfo(dto, ()->{

            return standardDao.findStandardList(dto);
        });
        return Utils.convert2PageData(page);



    }

    @Override
    public void addStandard(StandardDto dto) {

        //获得新编号
        Integer newId=getNewId();
        dto.setStandard_id(newId);
        standardDao.insert(dto);


    }

    @Override
    public void modifyStandard(StandardDto dto) {
        standardDao.update(dto);

    }

    @Override
    public void deleteStandard(Integer[] ids) {
        standardDao.delete(ids);

    }

    @Override
    public List<Standard> getStandardAll() {
        return standardDao.findAllStandard();
    }
}