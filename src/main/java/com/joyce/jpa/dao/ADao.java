package com.joyce.jpa.dao;

import com.joyce.jpa.model.AModel;
import com.joyce.jpa.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ADao extends JpaRepository<AModel, Integer> {
}
