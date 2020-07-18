package com.joyce.jpa.controller;

import com.alibaba.fastjson.JSONObject;
import com.joyce.jpa.SpringbootJpaApplication;
import com.joyce.jpa.dao.EmployeeJpaDao;
import com.joyce.jpa.model.EmployeeModel;
import com.joyce.jpa.service.EmployeeJpaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Service
public class MyCrudController {

    static Logger logger = LoggerFactory.getLogger(MyCrudController.class);

    @Autowired
    EmployeeJpaDao employeeJpaDao;

    @Autowired
    EmployeeJpaService employeeJpaService;

    // 查询全部
    @RequestMapping("/showall")
    @ResponseBody
    public List<EmployeeModel> findall() {
        List<EmployeeModel> list = employeeJpaDao.findAll();
        return list;
    }

    // 查询全部
    @RequestMapping("/showall/{pageNum}")
    @ResponseBody
    public Page<EmployeeModel> findallByPageNum(@PathVariable("pageNum") String pageNum) {
        Pageable pageable = PageRequest.of(Integer.parseInt(pageNum),3);
        Page<EmployeeModel> page = employeeJpaDao.findAll(pageable);
        return page;
    }

    @RequestMapping("findByUsername/{username}")
    @ResponseBody
    public List<EmployeeModel> findByUsername(@PathVariable("username") String username) {
        List<EmployeeModel> list = employeeJpaDao.findByUsername(username);
        return list;
    }

    @RequestMapping("/employee/onlyReturnTwoFields")
    @ResponseBody
    public List<Map<String, Object>> onlyReturnTwoFields() {
        List<Map<String, Object>> list = employeeJpaService.onlyReturnTwoFields();
        logger.info("list=======" + JSONObject.toJSON(list));
        return list;
    }

    @RequestMapping("/save")
    @ResponseBody
    public EmployeeModel save(String email, String username ) {
        EmployeeModel e = new EmployeeModel();
        e.setEmail(email);
        e.setUsername(username);
        EmployeeModel e2 = employeeJpaDao.save(e);
        return e2;
    }
}
