package com.joyce.jpa.dao;

import com.joyce.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeCrudDao extends JpaRepository<Employee,Integer> {

//    @Query(value = "SELECT * FROM Employee u WHERE u.username like %:username%")
    List<Employee> findByUsername(@Param("username") String username);
}
