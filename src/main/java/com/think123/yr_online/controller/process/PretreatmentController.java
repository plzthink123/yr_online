package com.think123.yr_online.controller.process;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.process.pretreatment.PretreatmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-16 16:56
 */
@RestController
@RequestMapping("/process/pretreatment")
@Slf4j
public class PretreatmentController {

    @Autowired
    private PretreatmentService pretreatmentService;

    @GetMapping("/pretreatment")
    public Map<String,Object> customerExecQuery(ProcessDto dto){
        //System.out.println(dto);
        return pretreatmentService.getProcessPageOnStatus5(dto);
    }
    @PutMapping("/pretreatment")
    public Result customerExecUpd(@RequestBody ProcessDto dto, HttpSession session ) throws InterruptedException {
        CurrUser currUser=(CurrUser)session.getAttribute("CurrUser");
        dto.setPretreat_person( currUser.getUserName());
        dto.setPretreat_num(dto.getProcess_groupnum());
        Date dt=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(dt);
        dto.setPretreat_date(format);
        pretreatmentService.modifyProcess(dto);
        return Result.successResult("!success！");
    }
}