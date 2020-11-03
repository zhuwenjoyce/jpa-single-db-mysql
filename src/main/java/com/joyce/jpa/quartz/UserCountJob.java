package com.joyce.jpa.quartz;

import com.joyce.jpa.dao.UserJpaDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/2
 */
@Slf4j
@Component
public class UserCountJob {

    @Autowired
    UserJpaDao userJpaDao;

//    @Scheduled(fixedDelay = 10000)
    public void countUsers(){
        long userCount = userJpaDao.count();
        log.info("t_users count = {}", userCount);
    }

}
