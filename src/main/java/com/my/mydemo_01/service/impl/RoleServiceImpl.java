package com.my.mydemo_01.service.impl;

import com.my.mydemo_01.entity.RoleEntity;
import com.my.mydemo_01.mapper.RoleMapper;
import com.my.mydemo_01.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<RoleEntity> selectRoleByUserId(String userId) {
        return roleMapper.selectRoleByUserId(userId);
    }
}
