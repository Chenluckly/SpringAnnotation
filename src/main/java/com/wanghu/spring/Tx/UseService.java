package com.wanghu.spring.Tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wanghu
 * @date 2021/12/26 16:09
 */
@Service
public class UseService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser(){
        userDao.insert();
        System.out.println("插入成功");
//        int i = 10/0;
    }
}
