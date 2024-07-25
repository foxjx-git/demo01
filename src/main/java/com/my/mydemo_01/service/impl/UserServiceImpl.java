package com.my.mydemo_01.service.impl;

import com.my.mydemo_01.dto.UserTokenDTO;
import com.my.mydemo_01.entity.TLiuUserEntity;
import com.my.mydemo_01.entity.UserTokenEntity;
import com.my.mydemo_01.mapper.UserMapper;
import com.my.mydemo_01.res.Result;
import com.my.mydemo_01.service.UserService;
import com.my.mydemo_01.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenService userTokenService;

    @Override
    public TLiuUserEntity queryByUserName(String userName) {
        return userMapper.queryByUserName(userName);
    }

    @Override
    public Result<UserTokenDTO> login(TLiuUserEntity userEntity, String passwordDto) {
        Result<UserTokenDTO> result = new Result<>();
        String password = userEntity.getPassword();
        if (passwordDto == null || password == null || !(password.equals(passwordDto))) {
            result.setCode(0);
            result.setMsg("login false!");
            //result.setData("password or user name is not correct");
        } else {

            UserTokenDTO userTokenDTO = new UserTokenDTO();
            userTokenDTO.setUserId(userEntity.getUserId());
            userTokenDTO.setUserToken(UUID.randomUUID().toString());
            result.setCode(1);
            result.setMsg("login success!");
            result.setData(userTokenDTO);
            userTokenService.storeUserToken(userTokenDTO);
        }
        System.out.println(result.toString());
        return result;
    }
}
