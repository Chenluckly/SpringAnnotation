package com.wanghu.spring.Test;

import com.wanghu.spring.Config.MainConfigOfPropertyValues;
import com.wanghu.spring.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author wanghu
 * @create 2021-11-23 0:02
 * @file com.wanghu.spring.Test-Administrator
 */
public class IOC_PropertyValue {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test() {
        printBeans(annotationConfigApplicationContext);
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        System.out.println(environment);
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        annotationConfigApplicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }

}
