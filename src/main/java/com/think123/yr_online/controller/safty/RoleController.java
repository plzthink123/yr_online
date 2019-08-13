package com.think123.yr_online.controller.safty;

import com.think123.yr_online.dataobject.Module;
import com.think123.yr_online.dto.Result;
import com.think123.yr_online.dto.RoleDto;
import com.think123.yr_online.service.safty.RoleService;
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
@RequestMapping("/safty/role")
@Slf4j
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public Map<String,Object> roleExecQuery(RoleDto dto){


        return roleService.getRolePage(dto);

    }

    @PostMapping("/role")
    public Result roleExecAdd(@RequestBody RoleDto dto ) throws InterruptedException {
        Thread.sleep(2000);
        roleService.addRole(dto);
        return Result.successResult("新增角色信息成功！");
    }

    @PutMapping("/role")
    public Result roleExecUpd(@RequestBody RoleDto dto ) throws InterruptedException {
        log.info("dto: {}",dto);
        roleService.modifyRole(dto);
        return Result.successResult("修改角色信息成功！");
    }

    @DeleteMapping("/role")
    public Result roleExecDel(@RequestBody Integer[] ids ) throws InterruptedException {

        roleService.deleteRole(ids);
        return Result.successResult("删除角色信息成功！");
    }

    @GetMapping("/allModule")
    public Result allModule()throws  InterruptedException{
       List<Module> modules=roleService.findAllModule();
        return Result.successResult("success",modules);
    }
    @GetMapping("/{ro_id}")
    public Result findOneRoleModule(@PathVariable Integer ro_id)throws  InterruptedException{
       List<Module> modules=roleService.findOneRoleModule(ro_id);
       return Result.successResult("success",modules);
    }
    @PutMapping("/addModule/{movekeys}")
    public Result addModule(@PathVariable("movekeys")Integer[] movekeys,@RequestBody RoleDto roleDto){
        roleService.addModule(movekeys,roleDto.getRo_id());
        return  Result.successResult("success");
    }
    @PutMapping("/deleteModule/{movekeys}")
    public Result deleteModule(@PathVariable("movekeys")Integer[] movekeys,@RequestBody RoleDto roleDto){
        roleService.deleteRole(movekeys,roleDto.getRo_id());
        return Result.successResult("success");
    }
}