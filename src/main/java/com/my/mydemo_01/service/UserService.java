package com.my.mydemo_01.service;


import com.my.mydemo_01.dto.UserTokenDTO;
import com.my.mydemo_01.entity.TLiuUserEntity;
import com.my.mydemo_01.res.Result;

public interface UserService {
    TLiuUserEntity queryByUserName(String userName);
    Result<UserTokenDTO> login(TLiuUserEntity userEntity, String passwordDto);



}
