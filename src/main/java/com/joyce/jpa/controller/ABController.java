package com.joyce.jpa.controller;

import com.joyce.jpa.dao.EmployeeJpaDao;
import com.joyce.jpa.model.AModel;
import com.joyce.jpa.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * DB 事务测试
 */
@RestController
public class ABController {

    @Autowired
    AService aService;

    @RequestMapping("/case1")
    public Map<String, Object> testCse1(String username) {
        aService.saveAandB_case1(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("time", LocalDateTime.now());
        return map;
    }

    @RequestMapping("/case2")
    public Map<String, Object> testCse2(String username) {
        aService.saveAandB_case2(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("time", LocalDateTime.now());
        return map;
    }

    @RequestMapping("/case3")
    public Map<String, Object> testCse3(String username) {
        aService.saveAandB_case3(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("time", LocalDateTime.now());
        return map;
    }

    @RequestMapping("/case4")
    public Map<String, Object> testCse4(String username) {
        aService.saveAandB_case4(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("time", LocalDateTime.now());
        return map;
    }

    @RequestMapping("/case5")
    public Map<String, Object> testCse5(String username) {
        aService.saveAandB_case5(username);
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("time", LocalDateTime.now());
        return map;
    }

}
