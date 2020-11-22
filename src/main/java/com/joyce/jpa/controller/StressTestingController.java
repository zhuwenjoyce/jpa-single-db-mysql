package com.joyce.jpa.controller;

import com.joyce.jpa.model.UserModel;
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

    /*
    performance compare result:
    jpa-single-db-mysql . /stress-testing/demo/1
    VS
    joyce-webflux-jpa-demo . /jpa/trasaction/demo/1
     */
    @RequestMapping("/stress-testing/demo/saveTwoRecords")
    @ResponseBody
    public UserModel saveTwoRecords() {
        return userJpaService.saveTwoRecords();
    }

    @RequestMapping("/stress-testing/demo/saveOneRecord")
    @ResponseBody
    public UserModel saveOneRecord() throws InterruptedException {
        return userJpaService.saveOneRecord();
    }

    @RequestMapping("/stress-testing/demo/saveOneRecordWithNoTransaction")
    @ResponseBody
    public UserModel saveOneRecordWithNoTransaction() {
        return userJpaService.saveOneRecordWithNoTransaction();
    }

    @RequestMapping("/stress-testing/demo/sleep-50ms")
    @ResponseBody
    public Map<String, String> sleep50ms() throws InterruptedException {
        Thread.sleep(50L);
        return map;
    }

}
