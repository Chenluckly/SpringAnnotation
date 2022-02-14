package com.wanghu.spring.Test;

import com.wanghu.spring.Config.MainConfigOfProfile;
import com.wanghu.spring.bean.Yellow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author wanghu
 * @date 2021/12/15 17:35
 */
public class IOC_Profile {

    /**
     * 1.使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active =(你的@Profile里的参数环境配置)
     */
    @Test
    public void test1(){
                AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
                String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
                for(String beanName:beanNamesForType){
                    System.out.println(beanName);
                }
            }


    /**
     * 使用代码激活环境
     *  1.创建一个applicationContext
     *  2.设置需要激活的环境配置
     *  3.注册主配置类
     *  4.启动刷新容器
     */
    @Test
    public void test2(){
//        1.创建一个applicationContext
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
//        2.设置需要激活的环境配置
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("Test");
//        3.注册主配置类
        annotationConfigApplicationContext.register(MainConfigOfProfile.class);
//        4.启动刷新容器
        annotationConfigApplicationContext.refresh();
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
        Object yellow = annotationConfigApplicationContext.getBean(Yellow.class);
        System.out.println(yellow);
        for(String beanName:beanNamesForType){
            System.out.println(beanName);
        }
    }

}
