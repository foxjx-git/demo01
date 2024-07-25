package com.my.mydemo_01.mapper;

import com.my.mydemo_01.entity.TLiuUserEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    TLiuUserEntity queryByUserName(String userName);
}
