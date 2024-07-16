package com.my.mydemo_01.controller;

import com.my.mydemo_01.dto.Account;
import com.my.mydemo_01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Account account){
        String userNameDto=account.getUserName();
        String passwordDto =account.getPassword();
        String password = userService.queryByUserName(userNameDto);
        return userService.login(password,passwordDto);
    }
}
