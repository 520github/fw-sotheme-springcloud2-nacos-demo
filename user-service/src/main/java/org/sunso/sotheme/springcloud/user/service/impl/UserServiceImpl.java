package org.sunso.sotheme.springcloud.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunso.sotheme.springcloud.user.entity.User;
import org.sunso.sotheme.springcloud.user.mapper.UserMapper;
import org.sunso.sotheme.springcloud.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getOneByUserId(Long userId) {
        return userMapper.findOneByUserId(userId);
    }
}
