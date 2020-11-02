package com.joyce.jpa.controller;

import com.joyce.jpa.model.EmployeeModel;
import com.joyce.jpa.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/2
 */
@RestController
public class StressTestingController {

    @Autowired
    private UserJpaService userJpaService;

    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("result", "success");
    }

    @RequestMapping("/stress-testing/demo/1")
    @ResponseBody
    public Map<String, String> 模拟正常业务(String email, String username ) {
        userJpaService.DB事务压测();
        return map;
    }

}
