package com.my.mydemo_01.controller;

import com.my.mydemo_01.annotations.MenuMapping;
import com.my.mydemo_01.entity.MenuEntity;
import com.my.mydemo_01.res.Result;
import com.my.mydemo_01.service.MenuSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    MenuSerivice menuSerivice;
    @PostMapping("/menu")
    @ResponseBody
    public List<MenuEntity> query(String userId){
        List<MenuEntity> menuEntities = menuSerivice.queryMenuByUserId(userId);
        return menuEntities;
    }
    @PostMapping("/menutest")
    @ResponseBody
    public Result<String>  menutest(String userToken,String menuKey){
        Result<String> result = menuSerivice.isValidMenu(userToken, menuKey);
        return result;
    }
    @PostMapping("/menu1")
    @ResponseBody
    @MenuMapping("menu001")
    public String menu1(String userToken){
        System.out.println("This is menu1, you can access to me!");
        return "This is menu1, you can access to me!";
    }

}
