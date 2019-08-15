package com.think123.yr_online.controller.info;

import com.think123.yr_online.dto.CustomerDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.info.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:43
 */
@RestController
@RequestMapping("/info/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public Map<String,Object> customerExecQuery(CustomerDto dto){

        return customerService.getCustomerPage(dto);
    }
    @GetMapping("/customer/all")
    public Result customerExecAll(){

        return Result.successResult("success",customerService.getCustomerAll());
    }

    @PostMapping("/customer")
    public Result customerExecAdd(@RequestBody CustomerDto dto ) throws InterruptedException {
        Thread.sleep(2000);
        customerService.addCustomer(dto);
        return Result.successResult("新增客户信息成功！");
    }

    @PutMapping("/customer")
    public Result customerExecUpd(@RequestBody CustomerDto dto ) throws InterruptedException {
        log.info("dto: {}",dto);
        customerService.modifyCustomer(dto);
        return Result.successResult("修改客户信息成功！");
    }


    @DeleteMapping("/customer")
    public Result customerExecDel(@RequestBody Integer[] ids ) throws InterruptedException {

        customerService.deleteCustomer(ids);
        return Result.successResult("删除客户信息成功！");
    }



}