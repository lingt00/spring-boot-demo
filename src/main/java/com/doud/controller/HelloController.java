package com.doud.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("hello.do")
    @ResponseBody
    public String hello(){
        List staffList = jdbcTemplate.queryForList("select * from staff");
        return JSONObject.toJSONString(staffList);
    }
}
