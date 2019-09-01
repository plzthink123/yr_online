package com.think123.yr_online.controller.process;

import com.think123.yr_online.dto.ProductDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.process.pkg.PkgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-25 10:17
 */
@RestController
@RequestMapping("/process/pkg")
@Slf4j
public class PkgController {
    @Autowired
    private PkgService pkgService;

    @GetMapping("/pkg")
    public Map<String, Object> printExecQuery(ProductDto dto) {

        return pkgService.getPkgPage(dto);
    }
    @PutMapping("/pkg/status")
    public Result customerExecUpd123(@RequestBody ProductDto dto, HttpSession session) throws InterruptedException {

        pkgService.modifyProductStatus(dto);
        pkgService.modifyProcessStatus(dto);
        return Result.successResult("质检成功！");
    }


}