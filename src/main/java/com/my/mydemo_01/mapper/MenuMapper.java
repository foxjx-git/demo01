package com.my.mydemo_01.mapper;

import com.my.mydemo_01.entity.MenuEntity;
import com.my.mydemo_01.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper {
    List<MenuEntity> selectMenuByRoleEntiy(List<RoleEntity> roleEntities);
    int countUserIdByMenuKey(String userId,String menuKey);
}
