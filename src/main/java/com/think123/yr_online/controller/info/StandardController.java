package com.think123.yr_online.controller.info;

import com.think123.yr_online.dto.Result;
import com.think123.yr_online.dto.StandardDto;
import com.think123.yr_online.service.info.StandardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:43
 */
@RestController
@RequestMapping("/info/standard")
@Slf4j
public class StandardController {
    @Autowired
    private StandardService standardService;

    @GetMapping("/standard")
    public Map<String,Object> standardExecQuery(StandardDto dto){


        return standardService.getStandardPage(dto);

    }

    @PostMapping("/standard")
    public Result standardExecAdd(@RequestBody StandardDto dto ) throws InterruptedException {
        Thread.sleep(2000);
        standardService.addStandard(dto);
        return Result.successResult("新增标准信息成功！");
    }

    @PutMapping("/standard")
    public Result standardExecUpd(@RequestBody StandardDto dto ) throws InterruptedException {
        log.info("dto: {}" ,dto);
        standardService.modifyStandard(dto);
        return Result.successResult("修改标准信息成功！");
    }

    @DeleteMapping("/standard")
    public Result standardExecDel(@RequestBody Integer[] ids ) throws InterruptedException {

        standardService.deleteStandard(ids);
        return Result.successResult("删除标准信息成功！");
    }

}