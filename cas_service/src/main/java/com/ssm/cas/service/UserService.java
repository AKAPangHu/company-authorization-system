package com.ssm.cas.service;

import com.ssm.cas.domain.Role;
import com.ssm.cas.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/26 21:37
 **/
public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();
    void save(UserInfo userInfo);
    UserInfo findById(String id) throws Exception;
    List<Role> findOthersRoles(String userId);
    void addRoleToUser(String userId, String[] roleIds);
}
