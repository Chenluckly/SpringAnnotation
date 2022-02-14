package com.wanghu.spring.Ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wanghu
 * @date 2021/12/27 19:15
 */
@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryProcessor.....运行了....postProcessBeanFactory");
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前BeanFactory中有+"+beanDefinitionCount+"个Bean");
        System.out.println(Arrays.asList(beanDefinitionNames));
    }
}
