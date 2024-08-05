package com.my.mydemo_01.service;

import com.my.mydemo_01.entity.MenuEntity;
import com.my.mydemo_01.entity.RoleEntity;
import com.my.mydemo_01.res.Result;

import java.util.List;

public interface MenuSerivice {
    List<MenuEntity> selectMenuByRoleEntiy(List<RoleEntity> roleEntities);
    List<MenuEntity> queryMenuByUserId(String userId);
    Result<String> isValidMenu(String token,String menuKey);
    int countUserIdByMenuKey(String userId,String menuKey);

}
