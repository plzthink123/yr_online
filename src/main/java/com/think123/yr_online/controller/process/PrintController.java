package com.think123.yr_online.controller.process;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.process.Print.PrintService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-24 12:29
 */
@RestController
@RequestMapping("/process/print")
public class PrintController {
    @Autowired
    PrintService printService;

    @GetMapping("/print")
    public Map<String, Object> printExecQuery(ProcessDto dto) {
        System.err.println(dto);
        return printService.getPrintPage(dto);

    }

    @PutMapping("/print")
    public Result printExecUpd(@RequestBody ProcessDto dto) {
        //System.err.println(dto);
        if(dto.getProcess_status().equals("15")) {
            printService.modifyPrint(dto);
        }else {
            Subject subject = SecurityUtils.getSubject();
            CurrUser dt = (CurrUser) subject.getPrincipal();
            dto.setPrint_person(dt.getUserName());
            Date date = new Date();
           String stringDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            dto.setPrint_date(stringDate);

            printService.modifyPrint(dto);

        }
        return Result.successResult("修改信息成功！！");

    }
}