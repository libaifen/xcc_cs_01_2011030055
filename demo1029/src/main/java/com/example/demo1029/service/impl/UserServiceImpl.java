package com.example.demo1029.service.impl;

import com.example.demo1029.Entity.User;
import com.example.demo1029.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(Long userId) {
        // 实际的实现，可以从数据库或其他数据源中获取用户信息
        // 这里仅提供一个简单的示例
        User user = new User();
        user.setId(userId);
        user.setUsername("realUser");
        return user;
    }
}