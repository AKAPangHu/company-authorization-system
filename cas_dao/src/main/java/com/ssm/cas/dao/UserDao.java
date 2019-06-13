package com.ssm.cas.dao;

import com.ssm.cas.domain.Role;
import com.ssm.cas.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/26 21:41
 **/
@Repository
public interface UserDao {
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "roles",
                    javaType = List.class,
                    many = @Many(select = "com.ssm.cas.dao.RoleDao.findRolesByUserId"))
    })
    UserInfo findByUserName(String username) throws Exception;

    @Select("select * from users where id = #{userId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "roles",
                    javaType = List.class,
                    many = @Many(select = "com.ssm.cas.dao.RoleDao.findRolesByUserId"))
    })
    UserInfo findById(String userId) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(id, email, username, password, phoneNum, status)" +
            "values(uuid(), #{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    void save(UserInfo userInfo);

    @Select("select * from role where id " +
            "not in(select roleId from users_role where userId = #{userId})")
    List<Role> findOthersRoles(String userId);

    @Insert("insert into users_role(userId, roleId) values(#{userId}, #{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
