package com.wanghu.spring.Controller;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author wanghu
 * @create 2021-11-17 17:55
 * @file com.wanghu.spring.Controller-Administrator
 */
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader ：元数据的读取者（读取的当前正在扫描的类的信息）
     * metadataReader the metadata reader for the target class：元数据的读者是目标类的元数据读取器
     *
     * @param metadataReaderFactory：元数据读取器工厂（可以获取其他类的信息）
     * metadataReaderFactory a factory for obtaining metadata readers for other classes (such as superclasses and interfaces)
     * 获取元数据读取器的工厂用于其他类(如超类和接口)
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata=metadataReader.getClassMetadata();
        //获取当前类资源（类的路径）
        Resource resource= metadataReader.getResource();

        String className=classMetadata.getClassName();
        System.out.println("--->"+className);
        if (className.contains("er")){
            return true;
        }

        return false;
    }
}
