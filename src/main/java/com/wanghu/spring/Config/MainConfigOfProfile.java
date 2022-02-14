package com.wanghu.spring.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wanghu.spring.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;


/**
 * @author wanghu
 * @date 2021/12/15 16:42
 *
 * Profile:
 *    Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 *开发环境，测试环境，生产环境
 * 数据源：（A）（B）（C）
 *
 * @Profile:指定组件在那个环境的情况下才能被注册到容器中，不指定，在任何环境下都能注册这个组件
 * 1.加了环境标识的bean，只有这个环境被激活的时候才能被注册到容器中。默认是default环境
 * 2.将@Profile注解写在配置类上，表示当环境已注解中的环境湘潭市，整个配置类才有效
 * 3.没有标注环境标识的bean，在任何环境都是加载的
 */
@Profile("Test")
@PropertySource("classpath:/dbConfig.properties")
@Configuration
public class MainConfigOfProfile  implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver ValueResolver;
    private String driverClass;

//    @Profile("Test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    };


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.ValueResolver=resolver;
        driverClass=ValueResolver.resolveStringValue("${db.driverClass}");
    }

    //这里加@Profile注解：就是加了环境标识
    @Profile("Test")
    @Bean("TestDataSource")
    public DataSource dataSourceTest(@Value("${db.password}")String password) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
            return dataSource;
        }


    @Profile("KaiFa")
    @Bean("KaiFaDataSource")
    public DataSource dataSourceKaiFa(@Value("${db.password}")String password) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql:mysql://localhost:3306/kaifa");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


    @Profile("ShengCheng")
    @Bean("ShengChanDataSource")
    public DataSource dataSourceShengChan(@Value("${db.password}")String password) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql:mysql://localhost:3306/shengchan");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


}

