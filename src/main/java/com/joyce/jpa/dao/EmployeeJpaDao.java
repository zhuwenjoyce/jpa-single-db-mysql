package com.joyce.jpa.dao;

import com.joyce.jpa.model.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeJpaDao extends JpaRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT u  FROM EmployeeModel u WHERE u.username like %:username%")
    List<EmployeeModel> findByUsername(@Param("username") String username);

//    Query注解,hql语句
//   适用于查询指定条件的数据
    @Query(value = "select e from EmployeeModel e where e.id >= :id order by  e.id desc ")
    Page<EmployeeModel> findEmailByIdAndPageable(@Param("id") Integer id, Pageable pageable);

    @Query(value = "SELECT * FROM employee WHERE id > :id " // 这里的employee指的是数据库表名，因为 nativeQuery=true
            , countQuery = "SELECT 1000 FROM dual" // 自定义查询数据总数的sql
            , nativeQuery = true) // nativeQuery=true使用原生sql
    Page<EmployeeModel> listEmployeeById(@Param("id") Integer id, Pageable pageable);

    // 这个代码可用，查询指定字段
    @Query(value = "select create_user createUser, username from employee", nativeQuery = true)
    List<Map<String,Object>> onlyReturnTwoFields();

}
