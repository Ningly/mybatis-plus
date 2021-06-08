package com.ning.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ning.mybatisplus.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectAllByName(String name);
}
