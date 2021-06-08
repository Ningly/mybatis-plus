package com.ning.mybatisplus;

import com.ning.mybatisplus.entity.User;
import com.ning.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;

@SpringBootTest
public class ServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testCount(){
        int count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testSaveBatch(){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user=new User();
            user.setName("花花"+i);
            user.setAge(i);
            users.add(user);
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b);
    }
}
