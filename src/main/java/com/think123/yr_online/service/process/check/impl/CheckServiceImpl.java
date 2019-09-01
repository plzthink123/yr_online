package com.think123.yr_online.service.process.check.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dao.process.CheckDao;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.ProductDto;
import com.think123.yr_online.service.process.check.CheckService;
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
public class CheckServiceImpl implements CheckService {
    private BigDecimal process_id;
    private Integer product_id;
    @Autowired
    private CheckDao checkDao;

    @PostConstruct//初始化方法注解
    public void init() {
       // process_id = checkDao.findMaxId();
        product_id=checkDao.findMaxId();
       /* if(product_id==null){
            product_id=new BigDecimal(0);
        }
        product_id=product_id.add(new BigDecimal(1));
        System.out.println(product_id+"  === ==before autoincrement");*/
    }

   private synchronized Integer getNewId() {
        Integer i = Integer.parseInt(String.valueOf(process_id));
        return ++i;
    }
   /*private synchronized Integer getNewProductId() {
        if(product_id==null){
            product_id=new BigDecimal(0);
        }
        Integer i = Integer.parseInt(String.valueOf(product_id));
       System.out.println(product_id+"  === ==after autoincrement");
        return ++i;
    }*/
   private synchronized Integer getNewProductId(){
       if(product_id==null){
           product_id=0;
       }
      return ++product_id;
   }

    @Override
    public Map<String, Object> getProcessPage(ProcessDto dto) {
        PageInfo<ProcessDto> page = Utils.createPageInfo(dto, () -> {
            //List<ProcessDto> processDtoList = checkDao.findProcessList(dto);
            return checkDao.findProcessList(dto);
        });
        return Utils.convert2PageData(page);
    }

    @Override
    public List<ProcessDto> getPlanPage(BigDecimal process_id) {
        return checkDao.findProcessPlanList(process_id);
    }

   /* @Override
    public void addProcess(ProcessDto dto) {
        Integer i = getNewId();
        BigDecimal decimal = new BigDecimal(i);
        dto.setProcess_id(decimal);

        checkDao.addProcess(dto);
    }*/

    @Override
    public void deleteProcess(BigDecimal[] ids) {
        for (BigDecimal d : ids) {
            checkDao.deleteProcess(d);
        }
    }

    @Override
    public void modifyProcess(ProcessDto dto) {
        checkDao.modifyProcess(dto);
    }

    @Override
    public void modifyProcessStatus(ProcessDto dto) {
        checkDao.modifyProcessStatus(dto);
    }

    @Override
    public Map<String, Object> getProcessPageOnStatus5(ProcessDto dto) {
        PageInfo<ProcessDto> page = Utils.createPageInfo(dto, () -> {
          //  List<ProcessDto> processDtoList = rawclothDao.findProcessList(dto);

            return checkDao.findProcessListOnStatus5(dto);
        });
        return Utils.convert2PageData(page);
    }

    @Override
    public void addProduct(ProductDto dto, List<BigDecimal> list) {
            dto.setProduct_id(getNewProductId());
            checkDao.addProduct(dto);
    }

    @Override
    public void updateStatus(ProductDto dto) {
        checkDao.updateStatus30(dto);
    }

    @Override
    public Map<String, Object> getCheckPage(ProductDto dto) {
        PageInfo<ProductDto> page = Utils.createPageInfo(dto, () -> {
            //List<ProcessDto> processDtoList = checkDao.findProcessList(dto);
            return checkDao.findProductList(dto);
        });
        return Utils.convert2PageData(page);
    }

    @Override
    public void modifyProcessStatusTo35(ProductDto dto, BigDecimal sum, CurrUser currUser) {
        dto.setCheckPerson(currUser.getUserName());

        checkDao.modifyProcessStatusTo35(dto);
    }

    @Override
    public void modifyProductStatusTo35(ProductDto dto) {
        checkDao.modifyProductStatusTo35(dto);
    }

}