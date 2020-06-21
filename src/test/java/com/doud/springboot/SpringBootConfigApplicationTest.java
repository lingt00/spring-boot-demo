package com.doud.springboot;

import com.doud.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigApplicationTest {

    @Autowired
    Person person;

    @Test
    public void testConfig(){
        System.out.println(person);
    }
}
