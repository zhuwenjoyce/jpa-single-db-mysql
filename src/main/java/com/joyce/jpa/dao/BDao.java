package com.joyce.jpa.dao;

import com.joyce.jpa.model.AModel;
import com.joyce.jpa.model.BModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BDao extends JpaRepository<BModel, Integer> {
}
