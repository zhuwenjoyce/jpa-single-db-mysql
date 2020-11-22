package com.joyce.jpa.dao;

import com.joyce.jpa.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaDao extends JpaRepository<UserModel, Long> {

}
