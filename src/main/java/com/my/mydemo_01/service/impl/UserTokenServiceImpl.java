package com.my.mydemo_01.service.impl;

import com.my.mydemo_01.dto.UserTokenDTO;
import com.my.mydemo_01.entity.UserTokenEntity;
import com.my.mydemo_01.mapper.UserTokenMapper;
import com.my.mydemo_01.res.Result;
import com.my.mydemo_01.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.my.mydemo_01.constant.Constans.UserDatas.*;

@Service
public class UserTokenServiceImpl implements UserTokenService {
    @Autowired
    UserTokenMapper userTokenMapper;

    @Override
    public Integer countByUserId(String userId) {

        Integer count= userTokenMapper.countByUserId(userId);
        System.out.println("xont"+count);
        return count;
    }


    @Override
    public int insertUserToken(UserTokenEntity userTokenEntity) {
        return userTokenMapper.insertUserToken(userTokenEntity);
    }

    @Override
    public int updateUserToken(UserTokenEntity userTokenEntity) {
        return userTokenMapper.updateUserToken(userTokenEntity);
    }

    @Override
    public Boolean storeUserToken(UserTokenDTO userTokenDTO) {
        Boolean storeFlag=false;
        UserTokenEntity userTokenEntity = new UserTokenEntity();
        LocalDateTime createTime = LocalDateTime.now();
        LocalDateTime validTime =createTime
                .plusDays(USER_VALID_DAY)
                .plusHours(USER_VALID_HOUR)
                .plusMinutes(USER_VALID_MINUTE)
                .plusSeconds(USER_VALID_SECOND);

        userTokenEntity.setUserId(userTokenDTO.getUserId());
        userTokenEntity.setUserToken(userTokenDTO.getUserToken());
        userTokenEntity.setCreateTime(createTime);
        userTokenEntity.setValidTime(validTime);

        if(countByUserId(userTokenDTO.getUserId())>0){
            updateUserToken(userTokenEntity);
            System.out.println("updateUserToken is successful");
        }else {
            insertUserToken(userTokenEntity);
            System.out.println("insertUserToken is successful");
        }
        storeFlag =true;
        return storeFlag;
    }

    @Override
    public List<UserTokenEntity> selectByToken(String token) {
        return userTokenMapper.selectByToken(token);
    }

    @Override
    public UserTokenEntity isValidToken(String token) {
        List<UserTokenEntity> userTokenEntities = selectByToken(token);

        if(userTokenEntities.isEmpty()){
            System.out.println("token does not exist");
            return null;
        }else {
            UserTokenEntity userTokenEntity = userTokenEntities.get(0);
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime validTime = userTokenEntity.getValidTime();
            if(now.isBefore(validTime)){
                System.out.println("token有效，拿返回相关信息");
                return userTokenEntity;
            }else{
                System.out.println("token无效，不在有效期之内");
                return null;
            }
        }
    }

}
