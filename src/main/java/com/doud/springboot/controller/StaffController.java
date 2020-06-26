package com.doud.springboot.controller;


import com.doud.springboot.dao.StaffMapper;
import com.doud.springboot.model.Staff;
import com.doud.springboot.model.StaffCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    StaffMapper staffMapper;

    @GetMapping("staff")
    public List<Staff> queryAllStaff(){
        return staffMapper.selectByExample(new StaffCriteria());
    }

}
