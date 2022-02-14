package com.wanghu.spring.Dao;

import org.springframework.stereotype.Repository;

/**
 * @author wanghu
 * @create 2021-11-15 21:53
 * @file com.wanghu.spring.Dao-Administrator
 */
//名字默认是类名首字母小写
@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao [lable=" + lable + "]";
    }
}