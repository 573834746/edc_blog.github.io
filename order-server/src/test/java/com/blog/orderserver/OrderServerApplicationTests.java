package com.blog.orderserver;

import com.blog.orderserver.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(value = {"classpath:application.properties"})
public class OrderServerApplicationTests {


    @Autowired
    BlogService blogService;

    @Test
    public void contextLoads() {
        blogService.selectObjects();

    }

}
