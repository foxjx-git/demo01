package com.my.mydemo_01.service;

import com.my.mydemo_01.dto.UserTokenDTO;
import com.my.mydemo_01.entity.UserTokenEntity;
import com.my.mydemo_01.res.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTokenService {
    Integer countByUserId(String userId);
    int insertUserToken(UserTokenEntity userTokenEntity);
    int updateUserToken(UserTokenEntity userTokenEntity);
    Boolean storeUserToken(UserTokenDTO userTokenDTO);
    List<UserTokenEntity> selectByToken(String token);
    UserTokenEntity isValidToken(String userToken);
}
