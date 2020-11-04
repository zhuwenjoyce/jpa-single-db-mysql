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
    public Map<String, String> stressTesting1() {
        userJpaService.stressTesting1();
        return map;
    }

    @RequestMapping("/stress-testing/demo/2")
    @ResponseBody
    public Map<String, String> stressTesting2() throws InterruptedException {
        Thread.sleep(5L);
        return map;
    }

    @RequestMapping("/stress-testing/demo/3")
    @ResponseBody
    public Map<String, String> stressTesting3() throws InterruptedException {
        return userJpaService.stressTesting2();
    }

}
