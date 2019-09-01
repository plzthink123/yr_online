package com.think123.yr_online.controller.process;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.ProcessDto;
import com.think123.yr_online.dto.ProductDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.process.check.CheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-15 16:52
 */
@RestController
@RequestMapping("/process/check")
@Slf4j
public class CheckController {

    @Autowired
    private CheckService checkService;

    @GetMapping("/check")
    public Map<String, Object> customerExecQuery(ProductDto dto) {
        //System.out.println(dto);
        return checkService.getCheckPage(dto);
    }
    @GetMapping("/check1")
    public Map<String, Object> customerExecQuery1(ProcessDto dto) {
        //System.out.println(dto);
        return checkService.getProcessPage(dto);
    }

    @GetMapping("/check/more/{process_id}")
    public Result customerExecQueryMore(@PathVariable("process_id") BigDecimal process_id) {
        //log.info("========================process_id = {}, type={}  ",process_id,process_id.getClass().getName());

        return Result.successResult("success", checkService.getPlanPage(process_id));
    }

    @PostMapping("/check")
    public Result customerExecAdd(@RequestBody ProductDto dto, HttpSession session) throws InterruptedException {
        Thread.sleep(1000);
        BigDecimal num1 = dto.getProduct_level1_num();
        BigDecimal num2 = dto.getProduct_level2_num();
        BigDecimal num3 = dto.getProduct_level3_num();
        BigDecimal num4 = dto.getProduct_level4_num();
        List<BigDecimal> list=new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);

        for(int i =0;i<list.size();i++){

            if(i==0){
                dto.setProduct_level("01");
                dto.setProduct_num(dto.getProduct_level1_num());
                checkService.addProduct(dto,list);
            }else if(i==1){
                dto.setProduct_level("02");
                dto.setProduct_num(dto.getProduct_level2_num());
                checkService.addProduct(dto,list);
            }
            else if(i==2){
                dto.setProduct_level("03");
                dto.setProduct_num(dto.getProduct_level3_num());
                checkService.addProduct(dto,list);
            }else if(i==3){
                dto.setProduct_level("04");
                dto.setProduct_num(dto.getProduct_level4_num());
                checkService.addProduct(dto,list);
            }
            checkService.updateStatus(dto);

        }
        return Result.successResult("新增plan信息成功！");
    }

    @DeleteMapping("/check")
    public Result managerExecDel(@RequestBody BigDecimal[] ids) throws InterruptedException {

        checkService.deleteProcess(ids);
        return Result.successResult("删除计划信息成功！");
    }

    @PutMapping("/check")
    public Result customerExecUpd(@RequestBody ProcessDto dto, HttpSession session) throws InterruptedException {
        System.out.println(dto.getGroup_num());
        checkService.modifyProcess(dto);
        return Result.successResult("修改process信息成功！");
    }
    @PutMapping("/check/status35")
    public Result customerExecUpd123(@RequestBody ProductDto dto, HttpSession session) throws InterruptedException {
        //1.更改product表的status
        //2.更改process表中的status,并添加check_person,date
        CurrUser currUser = (CurrUser) session.getAttribute("CurrUser");
        BigDecimal sum=dto.getProduct_level1_num().add(dto.getProduct_level2_num()).add(dto.getProduct_level3_num().add(dto.getProduct_level4_num()));
        dto.setCheckNum(sum);
        Date dt = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(dt);
        dto.setCheck_date(format);
        checkService.modifyProductStatusTo35(dto);
        checkService.modifyProcessStatusTo35(dto,sum,currUser);
        return Result.successResult("质检成功！");
    }

    @PutMapping("/check/status")
    public Result customerExecUpd1(@RequestBody ProcessDto dto, HttpSession session) throws InterruptedException {
        CurrUser currUser = (CurrUser) session.getAttribute("CurrUser");
        dto.setGroup_person(currUser.getUserName());
        dto.setProcess_status("05");

        Date dt = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(dt);
        dto.setGroup_date(format);
        log.info("+++++++++++=========================>==========+>,{}", dto);
        checkService.modifyProcessStatus(dto);
        return Result.successResult("投坯成功！");
    }

}