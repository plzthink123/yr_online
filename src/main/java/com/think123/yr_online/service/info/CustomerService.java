package com.think123.yr_online.service.info;

import com.think123.yr_online.dto.CustomerDto;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
public interface CustomerService {
    Map<String, Object> getCustomerPage(CustomerDto dto);

    void addCustomer(CustomerDto dto);

    void modifyCustomer(CustomerDto dto);

    void deleteCustomer(Integer[] ids);
}
