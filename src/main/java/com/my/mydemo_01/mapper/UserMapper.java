package com.my.mydemo_01.mapper;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    String queryByUserName(String userName);
}
