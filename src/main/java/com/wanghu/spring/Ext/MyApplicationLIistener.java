package com.wanghu.spring.Ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wanghu
 * @date 2021/12/27 19:50
 */
@Component
public class MyApplicationLIistener implements ApplicationListener {
//    当容器中发布事件以后，方法触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到的事件："+event);
    }
}
