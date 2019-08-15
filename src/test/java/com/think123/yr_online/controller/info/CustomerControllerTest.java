package com.think123.yr_online.controller.info;

import com.think123.yr_online.dto.CustomerDto;
import com.think123.yr_online.service.info.CustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author plzthink123
 * 2019-08-15 08:36
 */
public class CustomerControllerTest {
    @Autowired
    private CustomerService customerService;

    @Test
    public void customerExecQuery() {
        CustomerDto customerDto=new CustomerDto();
        Map<String, Object> customerPage = customerService.getCustomerPage(customerDto);
        for (Map.Entry<String, Object> entry : customerPage.entrySet()) {
                     System.out.println("key= " + entry.getKey() + " and value= "
                                         + entry.getValue());
                    }
    }
}