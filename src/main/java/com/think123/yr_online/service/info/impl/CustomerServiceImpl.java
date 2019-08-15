package com.think123.yr_online.service.info.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.info.CustomerDao;
import com.think123.yr_online.dataobject.Customer;
import com.think123.yr_online.dto.CustomerDto;
import com.think123.yr_online.service.info.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    private int id;

    @Autowired
    private CustomerDao customerDao;


    @PostConstruct//初始化方法注解
    public void init() {
        id=customerDao.findMaxId();
    }

    private synchronized int  getNewId() {
        return  ++id;
    }

    @Override
    public Map<String, Object> getCustomerPage(CustomerDto dto) {

        PageInfo<Customer> page = Utils.createPageInfo(dto, ()->{

            return customerDao.findCustomerList(dto);
        });
        return Utils.convert2PageData(page);



    }

    @Override
    public void addCustomer(CustomerDto dto) {

        //获得新编号
        dto.setCus_id(getNewId());
        customerDao.insert(dto);


    }

    @Override
    public void modifyCustomer(CustomerDto dto) {
        customerDao.update(dto);

    }

    @Override
    public void deleteCustomer(Integer[] ids) {
        customerDao.delete(ids);

    }

    @Override
    public List<Customer> getCustomerAll() {
        return customerDao.findAll();
    }
}