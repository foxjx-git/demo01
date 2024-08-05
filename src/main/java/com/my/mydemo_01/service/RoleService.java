package com.my.mydemo_01.service;

import com.my.mydemo_01.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> selectRoleByUserId(String userId);
}
