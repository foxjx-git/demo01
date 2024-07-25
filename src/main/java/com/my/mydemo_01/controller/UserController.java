package com.my.mydemo_01.controller;

import com.my.mydemo_01.dto.AccountDTO;
import com.my.mydemo_01.dto.UserTokenDTO;
import com.my.mydemo_01.entity.TLiuUserEntity;
import com.my.mydemo_01.entity.UserTokenEntity;
import com.my.mydemo_01.res.Result;
import com.my.mydemo_01.service.UserService;
import com.my.mydemo_01.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Result<UserTokenDTO> login(@RequestBody AccountDTO account) {
        Result<UserTokenDTO> result = new Result<>();
        String userNameDto = account.getUserName();
        String passwordDto = account.getPassword();

        TLiuUserEntity userEntity = userService.queryByUserName(userNameDto);
        if (userEntity == null) {
            result.setCode(1);
            result.setMsg("user is not exist");
            //result.setData("user is not exist");
        } else {
            //String password = userEntity.getPassword();
            result = userService.login(userEntity, passwordDto);
        }
        return result;
    }
    @Autowired
    UserTokenService userTokenService;
    @PostMapping("/query")
    @ResponseBody
    public Integer query (@RequestParam String userId){
        System.out.println("userId："+userId);
        Integer count=userTokenService.countByUserId(userId);
        System.out.println("count: "+count);
        return count;
    }

    @PostMapping("/insert")
    @ResponseBody
    public int insert(){
        UserTokenEntity userTokenEntity = new UserTokenEntity();
        userTokenEntity.setUserId("200900512552");
        userTokenEntity.setUserToken("dfdfdaffe5555");
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime newtime = currentDateTime.plusMinutes(3);
        userTokenEntity.setValidTime(newtime);
        userTokenEntity.setCreateTime(currentDateTime);
        int i = userTokenService.insertUserToken(userTokenEntity);
        return  i;
    }
    @PostMapping("/update")
    @ResponseBody
    public int update(){
        UserTokenEntity userTokenEntity = new UserTokenEntity();
        userTokenEntity.setUserId("20240719001");
        userTokenEntity.setUserToken("dfdfdaffe6666");
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime newtime = currentDateTime.plusMinutes(3);
        userTokenEntity.setValidTime(newtime);
        userTokenEntity.setCreateTime(currentDateTime);
        int i = userTokenService.updateUserToken(userTokenEntity);
        return  i;
    }
}
