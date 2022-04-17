package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthclubApplicationTests {

    @Test
    void contextLoads() {}

        @Resource
        private RedisTemplate<String, Object> redisTemplate;

        @Test
        void RedisTest(){
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<List>(List.class));
            redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//            List list = new ArrayList<User>();
//            User user = new User();
//
//            for (int i = 0;i<5;i++){
//                user = new User();
//                user.setUsername("kzb"+i);
//                user.setPassword("123456");
//                list.add(user);
//            }

            redisTemplate.opsForValue().set("kkk", "123");

//            List list2 = (List)redisTemplate.opsForValue().get("kkk");

//            User user1 = (User)list2.get(3);

//        String userName = (String)map.get("userName");

//            System.out.println(user1.getUsername());
    }

}
