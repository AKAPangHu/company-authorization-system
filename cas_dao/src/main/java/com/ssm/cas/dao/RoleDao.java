package com.ssm.cas.dao;

import com.ssm.cas.domain.Permission;
import com.ssm.cas.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/28 15:59
 **/
public interface RoleDao {

    @Select("select * from role where id in " +
            "(select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "permissions", column = "id",
                    many = @Many(select = "com.ssm.cas.dao.PermissionDao.findByRoleId"))

    })
    List<Role> findRolesByUserId(String userId);

    @Select("select * from role")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "permissions", column = "id",
                    many = @Many(select = "com.ssm.cas.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findAll();

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "permissions", column = "id",
                    one = @One(select = "com.ssm.cas.dao.PermissionDao.findByRoleId"))
    })
    Role findById(String id);

    @Insert("insert into role(id, roleName, roleDesc)" +
            "values(uuid(), #{roleName}, #{roleDesc})")
    void save(Role role);

    @Select("select * from permission where id " +
            "not in(select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOthersPermissions(String roleId);

    @Insert("insert into role_permission(roleId, permissionId) values(#{roleId}, #{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
