package com.think123.yr_online.controller.process;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.process.Arrange.ArrangeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-24 12:54
 */
@RestController
@RequestMapping("/process/arrange")
public class ArrangeController {
    @Autowired
    ArrangeService arrangeService;


    @GetMapping("/arrange")
    public Map<String, Object> printExecQuery(ProcessDto dto) {
        System.err.println(dto);
        return arrangeService.getArrangePage(dto);

    }

    @PutMapping("/arrange")
    public Result printExecUpd(@RequestBody ProcessDto dto) {
        //System.err.println(dto);
        if(dto.getProcess_status().equals("15")) {
            arrangeService.modifyArrange(dto);
        }else {
            Subject subject = SecurityUtils.getSubject();
            CurrUser dt = (CurrUser) subject.getPrincipal();
            dto.setArrange_person(dt.getUserName());
            Date date=new Date();
            String dateString=new SimpleDateFormat("yyyy-MM-dd").format(date);
            dto.setArrange_date(dateString);
            arrangeService.modifyArrange(dto);

        }
        return Result.successResult("修改信息成功！！");

    }
}