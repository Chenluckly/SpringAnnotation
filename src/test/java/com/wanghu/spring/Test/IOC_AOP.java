package com.wanghu.spring.Test;

import com.wanghu.spring.AOP.MathCalculator;
import com.wanghu.spring.Config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wanghu
 * @date 2021/12/20 19:13
 */
public class IOC_AOP {



    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        //必须使用容器里的，不能自己new
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        //正常的
        bean.div(1,1);
        //异常的
//        bean.div(1,0);
        applicationContext.close();
    }
}
