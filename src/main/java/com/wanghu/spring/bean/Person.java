package com.wanghu.spring.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author wanghu
 * @create 2021-11-15 21:03
 * @file com.wanghu.spring.bean-Administrator
 */
public class Person {

    //使用@Value赋值
    //1.基本数值
    //2.可以写spEL；#{}
    //3.可以写${}；取得配置文件【properties】中的值（在运行环境变量里面的值）

    @Value("耗子")
    private String name;
    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }



    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
    }


}
