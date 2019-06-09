package com.ssm.cas.dao;

import com.ssm.cas.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/28 21:33
 **/
public interface PermissionDao {
    @Select("SELECT * FROM permission where id in " +
            "(SELECT permissionId FROM role_permission WHERE roleId = #{roleId})")
    List<Permission> findByRoleId(String roleId);

    @Select("SELECT * FROM permission")
    List<Permission> findAll();

    @Select("SELECT * FROM permission where id = #{permissionId}")
    Permission findByPermissionId(String permissionId);

    @Insert("insert into permission(id, permissionName, url)" +
            "values(uuid(), #{permissionName}, #{url})")
    void save(Permission permission);

    @Delete("delete from role_permission where permissionId = #{permissionId}")
    void deleteInRolePermissionTableById(String permissionId);

    @Delete("delete from permission where id = #{id}")
    void deleteById(String id);
}
