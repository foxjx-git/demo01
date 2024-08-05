package com.my.mydemo_01.mapper;

import com.my.mydemo_01.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
   List<RoleEntity> selectRoleByUserId(String userId);
}
