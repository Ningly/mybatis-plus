package com.ning.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ning.mybatisplus.entity.User;
import com.ning.mybatisplus.mapper.UserMapper;
import com.ning.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //    @Resource
//    private UserMapper userMapper;
    @Override
    public List<User> selectAllByName(String name) {
        return baseMapper.selectAllByName(name);
    }
}
