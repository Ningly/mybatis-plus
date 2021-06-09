package com.ning.mybatisplus;

import com.ning.mybatisplus.entity.Product;
import com.ning.mybatisplus.entity.User;
import com.ning.mybatisplus.mapper.ProductMapper;
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
    @Resource
    private ProductMapper productMapper;


    @Test
    public void testInsert(){
        User user=new User();
        user.setName("ning");
        user.setAge(22);
        user.setEmail("dafsdfasf");
//        user.setDatetime(LocalDateTime.now());
//        user.setUpdatetime(LocalDateTime.now());
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
        user.setId(1402437340223361025L);
        user.setAge(221);
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testDelete(){
        int result = userMapper.deleteById(1402437340223361025L);
        System.out.println(result);
    }

    @Test
    public void testSelectAllByName(){
        List<User> users = userMapper.selectAllByName("Jone");
        users.forEach(System.out::println);
    }
    @Test
    public void testConcurrentUpdate() {

        //1、小李
        Product p1 = productMapper.selectById(1L);

        //2、小王
        Product p2 = productMapper.selectById(1L);

        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改结果：" + result1);

        //4、小王将商品减了30元，存入了数据库
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        if(result2 == 0){//更新失败，重试
            System.out.println("小王重试");
            //重新获取数据
            p2 = productMapper.selectById(1L);
            //更新
            p2.setPrice(p2.getPrice() - 30);
            productMapper.updateById(p2);
        }
        System.out.println("小王修改结果：" + result2);

        //最后的结果
        Product p3 = productMapper.selectById(1L);
        System.out.println("最后的结果：" + p3.getPrice());
    }
}
