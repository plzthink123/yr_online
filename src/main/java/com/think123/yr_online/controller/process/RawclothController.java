package com.think123.yr_online.controller.process;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.process.rawcloth.RawclothService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-15 16:52
 */
@RestController
@RequestMapping("/process/rawcloth")
@Slf4j
public class RawclothController {

    @Autowired
    private RawclothService rawclothService;

    @GetMapping("/rawcloth")
    public Map<String,Object> customerExecQuery(ProcessDto dto){
        //System.out.println(dto);
        return rawclothService.getProcessPage(dto);
    }
    @GetMapping("/rawcloth/more/{plan_id}")
    public Result customerExecQueryMore(@PathVariable("plan_id") Integer plan_id){

        return Result.successResult("success",rawclothService.getPlanPage(plan_id));
    }

    @PostMapping("/rawcloth")
    public Result customerExecAdd(@RequestBody ProcessDto dto, HttpSession session) throws InterruptedException {
        Thread.sleep(1000);
        BigDecimal groupnum = dto.getProcess_groupnum();
        System.out.println(groupnum);
        dto.setGroup_num(groupnum);
        dto.setProcess_status("00");

        rawclothService.addProcess(dto);
        return Result.successResult("新增plan信息成功！");
    }
    @DeleteMapping("/rawcloth")
    public Result managerExecDel(@RequestBody BigDecimal[] ids ) throws InterruptedException {

        rawclothService.deleteProcess(ids);
        return Result.successResult("删除计划信息成功！");
    }
    @PutMapping("/rawcloth")
    public Result customerExecUpd(@RequestBody ProcessDto dto,HttpSession session ) throws InterruptedException {
        System.out.println(dto.getGroup_num());
        rawclothService.modifyProcess(dto);
        return Result.successResult("修改process信息成功！");
    }
    @PutMapping("/rawcloth/status")
    public Result customerExecUpd1(@RequestBody ProcessDto dto,HttpSession session ) throws InterruptedException {
        CurrUser currUser=(CurrUser)session.getAttribute("CurrUser");
        dto.setGroup_person( currUser.getUserName());
        dto.setProcess_status("05");

        Date dt=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(dt);
        dto.setGroup_date(format);
       log.info("+++++++++++=========================>==========+>,{}",dto);
        rawclothService.modifyProcessStatus(dto);
        return Result.successResult("投坯成功！");
    }




}