package com.ning.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ning.mybatisplus.entity.User;
import com.ning.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class InterceptorTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSeleectPage(){
        Page<User> pageParam = new Page<>(1, 5);
        userMapper.selectPage(pageParam, null);
        System.out.println("==============================");
        System.out.println(pageParam.getTotal());
        System.out.println("===============hasPrevious===============");
        System.out.println(pageParam.hasPrevious());
        System.out.println("===============hasNext===============");
        System.out.println(pageParam.hasNext());
        List<User> userPageRecords = pageParam.getRecords();
        userPageRecords.forEach(System.out::println);
    }

    @Test
    public void testSelectPageByAge(){
        Page<User> pageParam = new Page<>(1, 5);
        userMapper.selectPageByAge(pageParam, 22);
        List<User> userPageRecords = pageParam.getRecords();
        userPageRecords.forEach(System.out::println);
    }
}
