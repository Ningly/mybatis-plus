package com.ning.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ning.mybatisplus.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectAllByName(String name);

}
