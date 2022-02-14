package com.wanghu.spring.Test;

import com.wanghu.spring.Ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanghu
 * @date 2021/12/27 19:19
 */
public class IOCTest_Ext {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ExtConfig.class);
//        发布事件
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });

        applicationContext.close();
    }

}
