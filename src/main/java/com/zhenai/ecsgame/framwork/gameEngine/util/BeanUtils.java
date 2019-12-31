package com.zhenai.ecsgame.framwork.gameEngine.util;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/16:25
 * @Description:
 */
public class BeanUtils {

    //将管理上下文的applicationContext设置成静态变量，供全局调用
    public static ConfigurableApplicationContext applicationContext;


    //定义一个获取已经实例化bean的方法
    public static <T> T getBean(Class<T> c){
        return applicationContext.getBean(c);
    }

}
