package com.wanghu.spring.Test;

import com.wanghu.spring.Config.MainConfig;
import com.wanghu.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanghu
 * @create 2021-11-15 21:09
 * @file com.wanghu.spring.Test-Administrator
 */
public class MainTest {

    public static void main(String[] args) {
//        老配置
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);
        char c []={'a','b','c','z','!','&','1','0','A','B','C','Z'};


        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig.class);//这里传的是类
        Person person = (Person)applicationContext.getBean(Person.class);
        System.out.println(person);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name:beanNamesForType){
            System.out.println(name);
        }

    }
}
