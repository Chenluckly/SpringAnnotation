package com.wanghu.spring.Conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wanghu
 * @create 2021-11-17 20:01
 * @file com.wanghu.spring.Conditional-Administrator
 */
//判断是否Linux系统
public class LinuxConditional implements Condition {

    /**
     * ConditionalContext:判断条件能使用的上下文（环境）
     * AnnotationTypeMetadata：注释信息
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //ConfigurableListableBeanFactory（可配置的bean工厂）
        //1.能获取到ioc使用beanFactory
        ConfigurableListableBeanFactory beanFactory=context.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader=context.getClassLoader();
        //3.获取当前环境信息
        Environment environment=context.getEnvironment();
        //4.获取bean定义的注册类
        //BeanDefinitionRegistry:Bean定义注册表
        BeanDefinitionRegistry registry=context.getRegistry();

        String property = environment.getProperty("os.name");
        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person2");
        if(property.contains("Linux")){
            return true;
        }
        return false;
    }


}
