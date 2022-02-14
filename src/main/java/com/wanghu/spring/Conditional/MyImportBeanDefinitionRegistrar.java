package com.wanghu.spring.Conditional;

import com.wanghu.spring.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wanghu
 * @create 2021-11-18 0:02
 * @file com.wanghu.spring.Conditional-Administrator
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata:当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition注册类
     * 把所有需要添加到容器中的bean；调用 BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.wanghu.spring.bean.Red");
        boolean definition1 = registry.containsBeanDefinition("com.wanghu.spring.bean.Blue");
        if(definition&&definition1){
            //指定bean名
            RootBeanDefinition rootBeanDefition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定bean
            registry.registerBeanDefinition("rainBow",rootBeanDefition);
        }

    }
}
