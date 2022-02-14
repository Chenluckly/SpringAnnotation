package com.wanghu.spring.Test;


import com.wanghu.spring.Config.MainConfig;
import com.wanghu.spring.Config.MainConfig2;
import com.wanghu.spring.bean.Blue;
import com.wanghu.spring.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author wanghu
 * @create 2021-11-15 21:55
 * @file com.wanghu.spring.Test-Administrator
 */
public class IOCTest {

    AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig.class);//这里传的是类
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig2.class);//这里传的是类
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }

        System.out.println("ioc容器创建成功");
//        //获取的对象都是单实例，信息只有一个，不论次数
        Person person =(Person) applicationContext.getBean("person2");
        Person person2 =(Person) applicationContext.getBean("person2");
//        System.out.println(person==person2);
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(MainConfig2.class);//这里传的是类
        ConfigurableEnvironment environment=applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        String[] nameForType =applicationContext.getBeanNamesForType(Person.class);
        for(String name:nameForType){
            System.out.println(name);
        }

        Map<String, Person> PersonOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(PersonOfType);
    }

    ////////////////////////////////////////////////////////////////////////////////



    @Test
    public void testImport(){
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        //详见MainConfig2
        //FactoryBean：工厂Bean获取的是调用的getObject创建的对象
        Object colorFactoryBean =applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean1 =applicationContext.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean==colorFactoryBean1);
        System.out.println("colorFactoryBean的类型是："+colorFactoryBean.getClass());

        Object colorFactoryBean3 =applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean3.getClass());
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
    }
}
