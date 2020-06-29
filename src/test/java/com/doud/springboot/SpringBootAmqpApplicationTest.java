package com.doud.springboot;

import com.doud.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTest {
    @Autowired
    Person person;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads(){
       /* Map<String,Object> msg = new HashMap<>();
        msg.put("msg","this is a person's info");
        msg.put("personInfo",person);*/
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.emps",new Person("李斯",22));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.emps",new Person("王五",23));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.emps",new Person("小明",21));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.emps",person);
        System.out.println("amqp执行完毕...");
    }

/*    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.emps");
        System.out.println(o.getClass());
        System.out.println(o);
    }*/
}
