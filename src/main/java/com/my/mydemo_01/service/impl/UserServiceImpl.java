package com.my.mydemo_01.service.impl;

import com.my.mydemo_01.mapper.UserMapper;
import com.my.mydemo_01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String queryByUserName(String userName) {
        return userMapper.queryByUserName(userName);
    }

    @Override
    public String login(String password,String passwordDto) {
        String returnStatus=null;
        if (passwordDto == null || password == null || password==passwordDto){
            returnStatus= "login false!";
        } else {
            returnStatus= "login success";
        }

        return returnStatus;
    }
}
