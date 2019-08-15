package com.think123.yr_online.controller.plan;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.PlanDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.plan.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-14 20:48
 */
@RestController
@RequestMapping("/plan/manager")
@Slf4j
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/manager")
    public Map<String,Object> customerExecQuery(PlanDto dto){
        //System.out.println(dto);
        return managerService.getPlanPage(dto);
    }

    @PostMapping("/manager")
    public Result customerExecAdd(@RequestBody PlanDto dto, HttpSession session) throws InterruptedException {
        Thread.sleep(1000);
        CurrUser currUser=(CurrUser)session.getAttribute("CurrUser");
        dto.setPlan_person( currUser.getUserName());
        dto.setPlan_status(0);
        Date dt=new Date();
        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        //simpleDateFormat.format(dt);
        dto.setPlan_date(dt);

        managerService.addPlan(dto);
        return Result.successResult("新增plan信息成功！");
    }

    @PutMapping("/manager")
    public Result customerExecUpd(@RequestBody PlanDto dto ) throws InterruptedException {
        log.info("dto: {}",dto);
        managerService.modifyPlan(dto);
        return Result.successResult("修改客户信息成功！");
    }


    @DeleteMapping("/manager")
    public Result managerExecDel(@RequestBody Integer[] ids ) throws InterruptedException {

        managerService.deleteManager(ids);
        return Result.successResult("删除计划信息成功！");
    }
    @DeleteMapping("/manager/notReal")
    public Result managerExecDelNotReal(@RequestBody Integer[] ids ) throws InterruptedException {

        managerService.deleteManagerNotReal(ids);
        return Result.successResult("删除计划信息成功！");
    }

}