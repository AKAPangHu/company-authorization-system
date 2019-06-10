package com.ssm.cas.service.impl;

import com.ssm.cas.dao.UserDao;
import com.ssm.cas.domain.Role;
import com.ssm.cas.domain.UserInfo;
import com.ssm.cas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/26 21:38
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * 对密码进行加密
     */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUserName(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert userInfo != null;
        return new User(
                userInfo.getUsername(), userInfo.getPassword(), getAuthority(userInfo));
    }

    List<SimpleGrantedAuthority> getAuthority(UserInfo userInfo) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        List<Role> roles = userInfo.getRoles();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        String password = userInfo.getPassword();

        userInfo.setPassword(bCryptPasswordEncoder.encode(password));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOthersRoles(String userId) {
        return userDao.findOthersRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }
}
