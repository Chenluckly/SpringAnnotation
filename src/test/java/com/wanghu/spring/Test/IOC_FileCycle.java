package com.wanghu.spring.Test;

import com.wanghu.spring.Config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author wanghu
 * @create 2021-11-18 23:47
 * @file com.wanghu.spring.Test-Administrator
 */
public class IOC_FileCycle {


    @Test
    public void test1(){
        //1.创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

//        annotationConfigApplicationContext.getBean("car");

        //关闭容器
        annotationConfigApplicationContext.close();
    }
}
