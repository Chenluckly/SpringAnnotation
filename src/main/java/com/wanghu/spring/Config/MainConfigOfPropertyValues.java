package com.wanghu.spring.Config;

import com.wanghu.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wanghu
 * @create 2021-11-19 17:00
 * @file com.wanghu.spring.Config-Administrator
 */
//使用PropertySource读取外部配置文件中的k/V保存到运行环境变量中
@PropertySource(value ={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {


    @Bean
    public Person person(){
        return new Person();
    }

}
