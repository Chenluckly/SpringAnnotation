package com.wanghu.spring.Config;

import com.wanghu.spring.Conditional.LinuxConditional;
import com.wanghu.spring.Conditional.MyImportBeanDefinitionRegistrar;
import com.wanghu.spring.Conditional.MyImportSelector;
import com.wanghu.spring.Conditional.WindowsConditional;
import com.wanghu.spring.bean.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author wanghu
 * @create 2021-11-17 18:34
 * @file com.wanghu.spring.Config-Administrator
 */
//类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效；
//@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})//导入组件，id默认是组件的全类名
public class MainConfig2  {

    //默认是单实例
    //默认是单实例的
    /**
     * ConfigurableBeanFactory(可配置Bean工厂)#SCOPE_PROTOTYPE(范围原型)
     * @see ConfigurableBeanFactory(可配置Bean工厂) # SCOPE_SINGLETON(范围单例)
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
     * @return\
     * @Scope:调整作用域
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 					每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 			以后每次获取就是直接从容器（map.get()）中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     *
     * Scope:范围，作用域
     */
//    @Scope("prototype")
      @Bean("person2")
      public Person person(){
//        System.out.println("给容器添加bean。。。");
        return new Person("小耗子",18);
      }

    /**
     * @Conditional({}) :按照一定的条件进行判断，满足条件给容器中注册bean
     *传递的是数组
     * 如果是windows，给容器中注册（JingXiang）
     * 如果是linux系统，给容器中注册（XiiaoFu）
     */
    @Conditional({WindowsConditional.class})
    @Bean("JingXiang")
      public Person person1(){
          return new Person("静香",18);
      }

      @Conditional({LinuxConditional.class})
    @Bean("XiaoFu")
    public Person person2(){
        return new Person("小夫",18);
    }

    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
     * 		3）、ImportBeanDefinitionRegistrar(进口Bean定义注册):手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 		1）、默认获取到的是工厂bean调用getObject创建的对象
     * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&符
     * 	就能获取到工厂bean 本身	colorFactoryBean
     */

   @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
