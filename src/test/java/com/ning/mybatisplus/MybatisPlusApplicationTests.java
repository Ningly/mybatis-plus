package com.ning.mybatisplus;

import com.ning.mybatisplus.entity.User;
import com.ning.mybatisplus.mapper.UserMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

//    @Autowired
    @Resource
    private UserMapper userMapper;
    @Test
    void testSelectList() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }


}
