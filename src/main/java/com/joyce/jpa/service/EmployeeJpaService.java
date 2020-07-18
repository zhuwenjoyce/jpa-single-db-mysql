package com.joyce.jpa.service;

import com.joyce.jpa.dao.EmployeeJpaDao;
import com.joyce.jpa.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeJpaService {
    @Autowired
    EmployeeJpaDao employeeJpaDao;

//    @Transactional(transactionManager = "masterTransactionManager")
    @Transactional(value = "masterTransactionManager")
    public EmployeeModel 模拟正常业务(EmployeeModel e){
        EmployeeModel e2 = employeeJpaDao.save(e);
        Optional<EmployeeModel> findEmployee = employeeJpaDao.findById(e2.getId());
        return findEmployee.get();
    }

//    @Transactional(transactionManager = "masterTransactionManager")
    @Transactional(value = "masterTransactionManager")
    public EmployeeModel 模拟业务出错_测试jpa事务_需指定事务(EmployeeModel e){
        EmployeeModel e2 = employeeJpaDao.save(e);
        int i = 1/0;
        Optional<EmployeeModel> findEmployee = employeeJpaDao.findById(e2.getId());
        return findEmployee.get();
    }

    public List<EmployeeModel> jpa自带的排序方式(Integer page, Integer size){
        List<EmployeeModel> list = employeeJpaDao.findAll(Sort.by("id").descending());
        return list;
    }

    public List<Map<String, Object>> onlyReturnTwoFields(){
        List<Map<String, Object>> list = employeeJpaDao.onlyReturnTwoFields();
        return list;
    }
}
