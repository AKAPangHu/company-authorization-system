package com.ssm.cas.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.cas.dao.RoleDao;
import com.ssm.cas.domain.Permission;
import com.ssm.cas.domain.Role;
import com.ssm.cas.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/28 21:51
 **/
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return roleDao.findAll();
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Permission> findOthersPermissions(String roleId) {
        return roleDao.findOthersPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
