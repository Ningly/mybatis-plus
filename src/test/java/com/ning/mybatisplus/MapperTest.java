package com.ning.mybatisplus;

import com.ning.mybatisplus.entity.User;
import com.ning.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user=new User();
        user.setName("ning");
        user.setAge(22);
        user.setEmail("dafsdfasf");
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testSelect(){
        User user = userMapper.selectById(1);
        System.out.println(user);

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);

        Map<String, Object> map = new HashMap<>();
        map.put("name","ning");
        map.put("age",22);
        List<User> users1 = userMapper.selectByMap(map);
        System.out.println(users1);
    }

    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(1L);
        user.setAge(22121);
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testDelete(){
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

    @Test
    public void testSelectAllByName(){
        List<User> users = userMapper.selectAllByName("Jone");
        users.forEach(System.out::println);
    }
}
