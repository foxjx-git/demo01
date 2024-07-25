package com.my.mydemo_01.mapper;
import com.my.mydemo_01.entity.UserTokenEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserTokenMapper {
    Integer countByUserId(@Param("userId") String userId);
    int insertUserToken(UserTokenEntity userTokenEntity);
    int  updateUserToken(UserTokenEntity userTokenEntity);
    List<UserTokenEntity> selectByToken(String token);
}

