package com.joyce.jpa.service;

import com.joyce.jpa.dao.ADao;
import com.joyce.jpa.dao.BDao;
import com.joyce.jpa.model.AModel;
import com.joyce.jpa.model.BModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AService {

    @Autowired
    ADao aDao;

    @Autowired
    BDao bDao;

    /**
     * DB事务测试，a 和 b 都能成功保存
     */
    @Transactional
    public void saveAandB_case1(String username) {
        username = username + "-case1";
        AModel a = new AModel();
        a.setUsername(username);
        aDao.save(a);

        BModel b = new BModel();
        b.setUsername(username);
        bDao.save(b);
    }

    /**
     * DB事务测试，a 能成功保存，b 不能，因为没有开启事务
     */
    public void saveAandB_case2(String username) {
        username = username + "-case2";
        AModel a = new AModel();
        a.setUsername(username);
        aDao.save(a);

        int i = 1/0;

        BModel b = new BModel();
        b.setUsername(username);
        bDao.save(b);
    }

    /**
     * DB事务测试，a 和 b 都不能成功保存，因为开启事务，所以回滚了 a
     */
    @Transactional
    public void saveAandB_case3(String username) {
        username = username + "-case3";
        AModel a = new AModel();
        a.setUsername(username);
        aDao.save(a);

        int i = 1/0;

        BModel b = new BModel();
        b.setUsername(username);
        bDao.save(b);
    }

    /**
     * DB事务测试，a 和 b 都能成功保存。
     * 证明事务在一个类里面方法内部调用其他方法，事务是成功的。
     */
    @Transactional
    public void saveAandB_case4(String username) {
        username = username + "-case4";
        business_a_and_b_for_case4(username);
    }

    private void business_a_and_b_for_case4(String username){
        AModel a = new AModel();
        a.setUsername(username);
        aDao.save(a);

        BModel b = new BModel();
        b.setUsername(username);
        bDao.save(b);
    }

    /**
     * DB事务测试，a 和 b 都不能成功保存！
     * 证明事务在一个类里面方法内部调用其他方法，事务是成功的。
     */
    @Transactional
    public void saveAandB_case5(String username) {
        username = username + "-case5";
        business_a_and_b_for_case5(username);
    }

    private void business_a_and_b_for_case5(String username){
        AModel a = new AModel();
        a.setUsername(username);
        aDao.save(a);
        int i = 1/0;
        BModel b = new BModel();
        b.setUsername(username);
        bDao.save(b);
    }

    /**
     * DB事务测试，a 和 b 都不能成功保存！
     * 证明事务在一个类里面方法内部调用其他方法，事务是成功的。
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAandB_case6(String username) {
        for (int i = 1; i < 5; i++) {
            String name = username + "-case6-" + i;
            business_a_and_b_for_case6(name, i);
        }
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void business_a_and_b_for_case6(String username, int i){
        AModel a = new AModel();
        a.setUsername(username);
        aDao.save(a);

        if( i > 3 ) {
            int q = 1/0;
        }
        BModel b = new BModel();
        b.setUsername(username);
        bDao.save(b);
    }
}
