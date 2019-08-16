package com.think123.yr_online.service.process.rawcloth.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.process.RawclothDao;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.service.process.rawcloth.RawclothService;
import com.think123.yr_online.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-15 18:56
 */
@Service
@Slf4j
@Transactional
public class RawclothServiceImpl implements RawclothService {
    private BigDecimal process_id;
    @Autowired
    private RawclothDao rawclothDao;
    @PostConstruct//初始化方法注解
    public void init() {
        process_id= rawclothDao.findMaxId();
    }

    private synchronized Integer  getNewId() {
        Integer i=Integer.parseInt(String.valueOf(process_id));
        return  ++i;
    }



    @Override
    public Map<String, Object> getProcessPage(ProcessDto dto) {
        PageInfo<ProcessDto> page = Utils.createPageInfo(dto, ()->{
            List<ProcessDto> processDtoList=rawclothDao.findProcessList(dto);
            for(ProcessDto processDto: processDtoList){
                System.out.println();
            }
              return rawclothDao.findProcessList(dto);
        });
        return Utils.convert2PageData(page);
    }

    @Override
    public List<ProcessDto> getPlanPage(Integer plan_id) {
            return rawclothDao.findProcessPlanList(plan_id);
    }

    @Override
    public void addProcess(ProcessDto dto) {
        Integer i=getNewId();
        BigDecimal decimal = new BigDecimal(i);
        dto.setProcess_id(decimal);
        log.info("dtoxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, {}",dto);
        rawclothDao.addProcess(dto);
    }

    @Override
    public void deleteProcess(BigDecimal[] ids) {
       for(BigDecimal d:ids){
           rawclothDao.deleteProcess(d);
       }
    }

    @Override
    public void modifyProcess(ProcessDto dto) {
        rawclothDao.modifyProcess(dto);
    }

    @Override
    public void modifyProcessStatus(ProcessDto dto) {
        rawclothDao.modifyProcessStatus(dto);
    }
/*

    @Autowired
    private RawclothDao rawclothDao;

    @PostConstruct//初始化方法注解
    public void init() {
        id= rawclothDao.findMaxId();
    }

    private synchronized Integer  getNewId() {
        return  ++id;
    }



    @Override
    public Map<String, Object> getPlanPage(PlanDto dto) {

        PageInfo<PlanDto> page = Utils.createPageInfo(dto, ()->{



            return rawclothDao.findRawcloth_CustomerList(dto);
        });
        return Utils.convert2PageData(page);



    }
*/

    /*@Override
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
*/
}