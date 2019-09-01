package com.think123.yr_online.controller.safty;

import com.think123.yr_online.dataobject.Role;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.dto.UserDto;
import com.think123.yr_online.service.safty.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:43
 */
@RestController
@RequestMapping("/safty/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Map<String, Object> userExecQuery(UserDto dto) {

        return userService.getUserPage(dto);

    }

    @PostMapping("/user")
    public Result userExecAdd(@RequestBody UserDto dto) throws InterruptedException {
        Thread.sleep(2000);
        userService.addUser(dto);
        return Result.successResult("新增User信息成功！");
    }

    @PutMapping("/user")
    public Result userExecUpd(@RequestBody UserDto dto) throws InterruptedException {
        log.info("dto: {}", dto);
        userService.modifyUser(dto);
        return Result.successResult("修改User信息成功！");
    }

    @DeleteMapping("/user")
    public Result userExecDel(@RequestBody String[] ids) throws InterruptedException {

        userService.deleteUser(ids);
        return Result.successResult("删除User信息成功！");
    }

    @GetMapping("/allRole")
    public Result allRole() throws InterruptedException {
        List<Role> allRole = userService.getAllRole();

        return Result.successResult("success", allRole);
    }

    @GetMapping("/{u_id}")
    public Result getOneUserRole(@PathVariable("u_id") String u_id) {
        List<Role> oneUserRole = userService.getOneUserRole(u_id);
        return Result.successResult("success", oneUserRole);
    }

    @PutMapping("/addRole/{movekeys}")
    public Result addRole(@PathVariable("movekeys") Integer[] movekeys, @RequestBody UserDto userDto) {
        userService.addRole(movekeys, userDto.getU_id());
        return Result.successResult("success");
    }

    @PutMapping("/deleteRole/{movekeys}")
    public Result deleteRole(@PathVariable("movekeys") Integer[] movekeys, @RequestBody UserDto userDto) {
        userService.deleteRole(movekeys, userDto.getU_id());
        return Result.successResult("success");
    }
}