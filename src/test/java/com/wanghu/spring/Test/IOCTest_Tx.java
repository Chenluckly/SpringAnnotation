package com.wanghu.spring.Test;

import com.wanghu.spring.Tx.TxConfig;
import com.wanghu.spring.Tx.UseService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanghu
 * @date 2021/12/26 16:16
 */
public class IOCTest_Tx {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UseService useService = applicationContext.getBean(UseService.class);
        useService.insertUser();

        applicationContext.close();
    }
}
