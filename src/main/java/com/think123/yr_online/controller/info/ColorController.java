package com.think123.yr_online.controller.info;

import com.think123.yr_online.dto.ColorDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.info.ColorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:43
 */
@RestController
@RequestMapping("/info/color")
@Slf4j
public class ColorController {
    @Autowired
    private ColorService colorService;

    @GetMapping("/color")
    public Map<String, Object> colorExecQuery(ColorDto dto) {

        return colorService.getColorPage(dto);

    }

    @GetMapping("/color/all")
    public Result colorExecQueryAll() {

        return Result.successResult("success", colorService.getAllColor());

    }

    @PostMapping("/color")
    public Result colorExecAdd(@RequestBody ColorDto dto) throws InterruptedException {
        Thread.sleep(2000);
        colorService.addColor(dto);
        return Result.successResult("新增花色信息成功！");
    }

    @PutMapping("/color")
    public Result colorExecUpd(@RequestBody ColorDto dto) throws InterruptedException {
        log.info("dto: {}", dto);
        colorService.modifyColor(dto);
        return Result.successResult("修改花色信息成功！");
    }

    @DeleteMapping("/color")
    public Result colorExecDel(@RequestBody Integer[] ids) throws InterruptedException {

        colorService.deleteColor(ids);
        return Result.successResult("删除花色信息成功！");
    }

}