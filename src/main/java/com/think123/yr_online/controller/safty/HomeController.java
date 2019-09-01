package com.think123.yr_online.controller.safty;

import com.think123.yr_online.base.CurrUser;
import com.think123.yr_online.dto.MenuDto;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.service.safty.HomeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/safty/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/menu")
    public Map<String, Object> allMenus(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        CurrUser currUser = (CurrUser) session.getAttribute("CurrUser");
        String userId = currUser.getUserId();

        List<MenuDto> menus = homeService.getMenusByCurrUser(currUser);

        map.put("list", menus);
        map.put("currUser", currUser);
        return map;
    }

    @DeleteMapping("/logout")
    public Result login_authentication() {
        try {
            //注销
            SecurityUtils.getSubject().logout();
            return Result.successResult("退出成功!");
        } catch (Exception e) {
            return Result.failResult("退出失败");
        }
    }
    @GetMapping("/currUser")
    public CurrUser getCurrUser(){
        Subject subject=SecurityUtils.getSubject();
        Object obj=subject.getPrincipal();
        return (CurrUser)obj;
    }

    @GetMapping("/m-menu")
    public List<MenuDto> mobileMenus(){
        CurrUser currUser=(CurrUser)SecurityUtils.getSubject().getPrincipal();
        List<MenuDto> menusByCurrUser = homeService.getMobileMenusByCurrUser(currUser);
        return menusByCurrUser;
    }

}
