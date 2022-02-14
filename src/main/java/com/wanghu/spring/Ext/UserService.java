package com.wanghu.spring.Ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author wanghu
 * @date 2021/12/27 20:13
 */
@Service
public class UserService {

    @EventListener(classes= ApplicationEvent.class)
    public void Listeren(ApplicationEvent event){
        System.out.println("UserService....监听的事件："+event);
    }
}
