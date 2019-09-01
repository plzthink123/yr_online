package com.think123.yr_online.controller.process;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.process.dye.DyeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-23 22:18
 */
@Slf4j
@RestController
@RequestMapping("/process/dye")
public class DyeController {
    @Autowired
    DyeService dyeService;

    @GetMapping("/dye")
    public Map<String, Object> dyeExecQuery(ProcessDto dto) {
        System.err.println(dto);
        return dyeService.getDyePage(dto);

    }
/*
    @PutMapping("/dye")
    public Result dyeExecUpd(@RequestBody ProcessDto dto) {
        //System.err.println(dto);
        if(dto.getProcess_status().equals("10")) {
            dyeService.modifyDye(dto);
        }else {
            Subject subject = SecurityUtils.getSubject();
            UserDto dt = (UserDto) subject.getPrincipal();
            dto.setDye_person(dt.getU_name());
            dto.setDye_date(new Date());
            dyeService.modifyDye(dto);

        }
        return Result.successResult("修改信息成功！！");
    }
*/
    @PutMapping("/dye")
    public Result dyeExecUpd(@RequestBody ProcessDto dto){
        if(dto.getProcess_status().equals("10")){
            dyeService.modifyDye(dto);
        }else{
            Subject subject= SecurityUtils.getSubject();
            CurrUser currUser= (CurrUser) subject.getPrincipal();
            dto.setDye_person(currUser.getUserName());
            Date dt = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(dt);
            dto.setDye_date(format);
            dyeService.modifyDye(dto);
        }
        return Result.successResult("修改信息成功");
    }

}