package com.think123.yr_online.service.info.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.info.CustomerDao;
import com.think123.yr_online.dataobject.Customer;
import com.think123.yr_online.dto.CustomerDto;
import com.think123.yr_online.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author plzthink123
 * 2019-08-09 15:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void getCustomerPage() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPageNum(1);
        customerDto.setPageSize(5);

        PageInfo<Customer> page = Utils.createPageInfo(customerDto, () -> {
            return customerDao.findCustomerList(customerDto);
        });
        System.out.println(page);
    }

    @Test
    public void addCustomer() {
    }
}