package com.think123.yr_online.controller;

import com.think123.yr_online.dto.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author plzthink123
 * 2019-08-14 12:02
 */
@RestController
public class ShiroController {

    @RequestMapping("/loginTo")
    public Result loginTo() {
        return Result.successResult("请登录!");
    }

    @RequestMapping("/unauthorized")
    public Result unauthorized() {
        return Result.successResult("没有权限");
    }

}