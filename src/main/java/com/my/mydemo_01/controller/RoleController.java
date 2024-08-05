package com.my.mydemo_01.controller;

import com.my.mydemo_01.entity.RoleEntity;
import com.my.mydemo_01.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    @PostMapping("/role")
    @ResponseBody
    public List<RoleEntity> selectRoleByUserId(String userId){
        List<RoleEntity> roleEntities = roleService.selectRoleByUserId(userId);
        System.out.println("roleEntities"+roleEntities);
        return roleEntities;
    }
}
