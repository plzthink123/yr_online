package com.think123.yr_online.controller.safty;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.safty.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author plzthink123
 * 2019-08-14 14:14
 */
@RestController
@RequestMapping("/safty/password")
public class PasswordController {
    @Autowired
    private UserService userService;


    @RequestMapping("/getCurrUser")
    public Result getCurrUser(HttpSession session){
        CurrUser currUser = (CurrUser) session.getAttribute("CurrUser");
       String u_id= currUser.getUserId();
       return Result.successResult("success",u_id);
    }

    @PutMapping("/pwd/{old_pwd}/{u_pwd}")
    public Result changePWD(@PathVariable("old_pwd")String oldpwd,@PathVariable("u_pwd")String pwd,HttpSession session){
        CurrUser currUser = (CurrUser)session.getAttribute("CurrUser");
        String u_id=currUser.getUserId();
        String db_old_pwd=userService.findOldPasswordById(u_id);
        if(!db_old_pwd.equals(oldpwd)){
            return Result.failResult("原密码输入错误!");
        }
        userService.changePasswordById(u_id,pwd);
        SecurityUtils.getSubject().logout();
       return  Result.successResult("密码修改成功!");
    }

}