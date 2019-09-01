package com.think123.yr_online.controller.safty;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dataobject.Role;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.dto.UserDto;
import com.think123.yr_online.service.safty.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author plzthink123
 * 2019-08-13 15:07
 */
@RestController
@RequestMapping("/safty/login")
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login/{u_name}/{u_pwd}")
    public Result dologin(@PathVariable("u_name") String u_name, @PathVariable("u_pwd") String u_pwd, HttpSession session) {
        UserDto userDto = new UserDto();
        userDto.setU_name(u_name);
        userDto.setU_pwd(u_pwd);
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(u_name, u_pwd);
            subject.login(token);
            if (subject.isAuthenticated()) {
                CurrUser currUser = (CurrUser) subject.getPrincipal();

                List<Role> roles = userService.selectRoleByUserId(currUser.getUserId());

                session.setAttribute("userRoles", roles);
                session.setAttribute("CurrUser", currUser);
                return Result.successResult("success", currUser);
            }
            return Result.failResult("failed!");
        } catch (UnknownAccountException e) {
            return Result.failResult("用户名不存在！");

        } catch (IncorrectCredentialsException e) {
            return Result.failResult("账户密码不正确!");
        } catch (LockedAccountException e) {
            return Result.failResult("用户名被锁定 !");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failResult("系统错误！");
        }

    }
}