package com.my.mydemo_01.service.impl;

import com.my.mydemo_01.entity.MenuEntity;
import com.my.mydemo_01.entity.RoleEntity;
import com.my.mydemo_01.entity.UserTokenEntity;
import com.my.mydemo_01.mapper.MenuMapper;
import com.my.mydemo_01.res.Result;
import com.my.mydemo_01.service.MenuSerivice;
import com.my.mydemo_01.service.RoleService;
import com.my.mydemo_01.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuSeriviceImpl implements MenuSerivice {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    RoleService roleService;
    @Autowired
    UserTokenService userTokenService;
    @Override
    public List<MenuEntity> selectMenuByRoleEntiy(List<RoleEntity> roleEntities) {
        List<MenuEntity> menuEntities = menuMapper.selectMenuByRoleEntiy(roleEntities);
        System.out.println("menuEntities: "+menuEntities);
        return menuEntities;
    }

    @Override
    public List<MenuEntity> queryMenuByUserId(String userId) {
        List<RoleEntity> roleEntities = roleService.selectRoleByUserId(userId);
        System.out.println("get roleEntities in the funtion of query successfully!");
        System.out.println("roleEntities: \n"+roleEntities);
        List<MenuEntity> menuEntities = selectMenuByRoleEntiy(roleEntities);
        System.out.println("menuEntities:\n"+menuEntities);
        return menuEntities;
    }

    @Override
    public Result<String> isValidMenu(String userToken,String menuKey) {
        Result result=new Result();
        UserTokenEntity userTokenEntity = userTokenService.isValidToken(userToken);
        if (userTokenEntity==null){
            result.setMsg("token is not valid");
            result.setCode(0);
            result.setData("token is not valid!");
        }else {
            String userId = userTokenEntity.getUserId();
            int count=countUserIdByMenuKey(userId,menuKey);
            if (count>0){
                result.setCode(1);
                result.setMsg("token is valid and menuKey is valid");
                result.setData("you can use the menu");
            }else {
                result.setCode(0);
                result.setMsg("token is valid but menuKey is not valid");
                result.setData("you can't use the menu");
            }
        }
        System.out.println("result:\n"+result);
        return result;
    }

    @Override
    public int countUserIdByMenuKey(String userId,String menuKey) {
        return menuMapper.countUserIdByMenuKey(userId,menuKey);
    }


}
