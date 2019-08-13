package com.think123.yr_online.service.info.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.info.ColorDao;
import com.think123.yr_online.dataobject.Color;
import com.think123.yr_online.dto.ColorDto;
import com.think123.yr_online.service.info.ColorService;
import com.think123.yr_online.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
@Service
@Slf4j
@Transactional
public class ColorServiceImpl implements ColorService {

    private Integer id;

    @Autowired
    private ColorDao ColorDao;


    @PostConstruct//初始化方法注解
    public void init() {
        id=ColorDao.findMaxId();
    }

    private synchronized Integer  getNewId() {
        return  ++id;
    }

    @Override
    public Map<String, Object> getColorPage(ColorDto dto) {

        PageInfo<Color> page = Utils.createPageInfo(dto, ()->{

            return ColorDao.findColorList(dto);
        });
        return Utils.convert2PageData(page);



    }

    @Override
    public void addColor(ColorDto dto) {

        //获得新编号
        dto.setCo_id(getNewId());
        ColorDao.insert(dto);


    }

    @Override
    public void modifyColor(ColorDto dto) {
        ColorDao.update(dto);

    }

    @Override
    public void deleteColor(Integer[] ids) {
        ColorDao.delete(ids);

    }
}