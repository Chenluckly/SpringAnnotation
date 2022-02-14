package com.wanghu.spring.Config;

import com.wanghu.spring.Controller.MyTypeFilter;
import com.wanghu.spring.Service.BookService;
import com.wanghu.spring.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.logging.Filter;

/**
 * @author wanghu
 * @create 2021-11-15 21:14
 * @file com.wanghu.spring.Config-Administrator
 * 配置类等于配置文件
 */
@Configuration //告诉spring这是一个配置类
//excludeFilters排除

//@ComponentScan(value = "com.wanghu",excludeFilters ={
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
//})

@ComponentScan(value = "com.wanghu",includeFilters ={
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)

//多注解
//@ComponentScans(
//        value = {
//                @ComponentScan(value = "com.wanghu",includeFilters ={
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
//                },useDefaultFilters = false),
//                @ComponentScan(value = "com.wanghu",excludeFilters ={
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
//                })
//        }
//)
//ComponentScan value：指定要扫描的包
// FilterType=Fiflter[]：指定扫描的时候按照什么规则排除那些组件
//includeFilter=Fiflter[]：指定扫描的时候只需要包含那些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE：按照给定的类型,类的类型
//FilterType.ASPECTJ:使用ASPECTJ表达式
//FilterType.REGEX:使用正则表达式指定
//FilterType.CUSTOM:使用自定义规则
public class MainConfig {
    //给容器注册一个bean，类型为返回值的类型，id默认使用方法名作为id
    @Bean("person1")
    public Person person(){
        return new Person("栗子",20);
    }
}
