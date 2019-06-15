package com.ssm.cas.service;

import com.ssm.cas.domain.Permission;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/29 14:11
 **/
public interface PermissionService {
    List<Permission> findAll(int page, int pageSize);

    Permission findById(String id);

    void save(Permission permission);

    void deleteById(String id);
}
