package com.wanghu.spring.Test;

import com.wanghu.spring.Config.MainConfigAutowired;
import com.wanghu.spring.Service.BookService;
import com.wanghu.spring.bean.Boss;
import com.wanghu.spring.bean.Car;
import com.wanghu.spring.bean.Color;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author wanghu
 * @create 2021-11-18 23:47
 * @file com.wanghu.spring.Test-Administrator
 */
public class IOC_AuyoWired {


    @Test
    public void test1(){
        //1.创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(MainConfigAutowired.class);
        System.out.println("容器创建完成");

        BookService bookService = annotationConfigApplicationContext.getBean(BookService.class);
        System.out.println(bookService);
        System.out.println("****************************************");
        Boss boss = annotationConfigApplicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = annotationConfigApplicationContext.getBean(Car.class);
        System.out.println(car);
        Color color = annotationConfigApplicationContext.getBean(Color.class);
        System.out.println(color);
        System.out.println(annotationConfigApplicationContext);
//        BookDao bookDao = annotationConfigApplicationContext.getBean(BookDao.class);
//        System.out.println(bookDao);

        //关闭容器
        annotationConfigApplicationContext.close();
    }
}
