package com.joyce.jpa.service;

import com.joyce.jpa.dao.UserJpaDao;
import com.joyce.jpa.model.EmployeeModel;
import com.joyce.jpa.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/2
 */
@Service
public class UserJpaService {

    @Autowired
    UserJpaDao userJpaDao;

    private Random random = new Random();

    @Transactional // (value = "transactionManager")
    public UserModel saveTwoRecords(){
        UserModel user = UserModel.builder()
                .age(random.nextInt(10))
                .username(UUID.randomUUID().toString())
                .birthdayDateTime(ZonedDateTime.now().minusDays(new Random().nextInt(40 * 365 - 1)))
                .remark("jpa-trasaction-1-1")
                .createDateTime(ZonedDateTime.now())
                .build();
        UserModel userModel = userJpaDao.save(user);
        long id = userModel.getUserId();

        UserModel user2 = UserModel.builder()
                .age(random.nextInt(10))
                .username(UUID.randomUUID().toString())
                .birthdayDateTime(ZonedDateTime.now().minusDays(new Random().nextInt(40 * 365 - 1)))
                .remark("jpa-trasaction-1-2. user_id=" + id)
                .createDateTime(ZonedDateTime.now())
                .build();
        UserModel userModel2 = userJpaDao.save(user2);
        return userModel2;
    }

    @Transactional
    public UserModel saveOneRecord() {
        UserModel user = UserModel.builder()
                .age(random.nextInt(10))
                .username(UUID.randomUUID().toString())
                .birthdayDateTime(ZonedDateTime.now().minusDays(new Random().nextInt(40 * 365 - 1)))
                .remark("jpa-trasaction-2")
                .createDateTime(ZonedDateTime.now())
                .build();
        return userJpaDao.save(user);
    }

    public UserModel saveOneRecordWithNoTransaction() {
        UserModel user = UserModel.builder()
                .age(random.nextInt(10))
                .username(UUID.randomUUID().toString())
                .birthdayDateTime(ZonedDateTime.now().minusDays(new Random().nextInt(40 * 365 - 1)))
                .remark("jpa-trasaction-3")
                .createDateTime(ZonedDateTime.now())
                .build();
        return userJpaDao.save(user);
    }

    public UserModel findByUsername(String username) {
        return userJpaDao.findByUsername(username);
    }
}
