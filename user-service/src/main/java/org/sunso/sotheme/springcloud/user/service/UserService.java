package org.sunso.sotheme.springcloud.user.service;

import org.sunso.sotheme.springcloud.user.entity.User;

public interface UserService {

    public User getOneByUserId(Long userId);
}
