package com.ssm.cas.service;

import com.ssm.cas.domain.Permission;
import com.ssm.cas.domain.Role;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/28 21:51
 **/

public interface RoleService {
    List<Role> findAll(Integer page, Integer pageSize);

    Role findById(String id);

    void save(Role role);

    List<Permission> findOthersPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
