package com.doud.springboot;

import com.doud.springboot.bean.Person;
import com.doud.springboot.dao.StaffMapper;
import com.doud.springboot.model.Staff;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigApplicationTest {

    @Autowired
    Person person;

    @Autowired
    DataSource dataSource;

    @Autowired
    StaffMapper staffMapper;

    TestRestTemplate template = new TestRestTemplate();

    String root = "http://127.0.0.1:8080";

    @Test
    public void testConfig(){
        System.out.println(person);
    }

    @Test
    public void testJdbc() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testStaff(){
        System.out.println(staffMapper.countByExample(null));
    }

    @Test
    public void testStaffList(){
       String result = template.getForObject(root+"/staff",String.class);

       Assert.assertNotNull("访问失败",result);
    }

}
