package com.doud.springboot.mq;

import com.doud.springboot.bean.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @RabbitListener(queues = "atguigu.emps")
    public void receivePerson(Person person){
        System.out.println("Person消费者...");
        System.out.println("person info:"+person.toString());
    }
}
