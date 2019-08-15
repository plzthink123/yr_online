package com.think123.yr_online.service.plan;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.plan.ManagerDao;
import com.think123.yr_online.dto.PlanDto;
import com.think123.yr_online.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-14 20:50
 */
@Service
@Slf4j
@Transactional
public class ManagerServiceImpl implements  ManagerService{

    private Integer id;

    @Autowired
    private ManagerDao managerDao;

    @PostConstruct//初始化方法注解
    public void init() {
        id= managerDao.findMaxId();
    }

    private synchronized Integer  getNewId() {
        return  ++id;
    }



    @Override
    public Map<String, Object> getPlanPage(PlanDto dto) {

        PageInfo<PlanDto> page = Utils.createPageInfo(dto, ()->{



            return managerDao.findPlan_CustomerList(dto);
        });
        return Utils.convert2PageData(page);



    }

    @Override
    public void deleteManager(Integer[] ids) {
        managerDao.deleteManager(ids);
    }

    @Override
    public void deleteManagerNotReal(Integer[] ids) {
        managerDao.deleteManagerNotReal(ids);
    }

    @Override
    public void addPlan(PlanDto dto) {
        dto.setPlan_id(getNewId());
       log.info("managerServiceImpl check  dto value = {}",dto);
        managerDao.addPlan(dto);
    }

    @Override
    public void modifyPlan(PlanDto dto) {
        managerDao.modifyPlan(dto);
    }

    /*@Override
    public void addColor(PlanDto dto) {

        //获得新编号
        dto.setCo_id(getNewId());
        managerDao.insert(dto);


    }

    @Override
    public void modifyColor(ColorDto dto) {
        ColorDao.update(dto);

    }

    @Override
    public void deleteColor(Integer[] ids) {
        ColorDao.delete(ids);

    }*/
}