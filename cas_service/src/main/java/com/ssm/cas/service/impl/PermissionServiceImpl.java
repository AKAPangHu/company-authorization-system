package com.ssm.cas.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.cas.dao.PermissionDao;
import com.ssm.cas.domain.Permission;
import com.ssm.cas.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/29 14:12
 **/
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    private final PermissionDao permissionDao;

    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public List<Permission> findAll(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return permissionDao.findAll();
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findByPermissionId(id);
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public void deleteById(String id) {
        //由于外键的关系，首先删除role_permission中的权限
        permissionDao.deleteInRolePermissionTableById(id);

        permissionDao.deleteById(id);
    }
}
