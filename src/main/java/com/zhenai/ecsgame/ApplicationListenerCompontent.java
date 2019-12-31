package com.zhenai.ecsgame;

import com.zhenai.ecsgame.Manager.RobotManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/15:32
 * @Description:
 */
@Component
public class ApplicationListenerCompontent implements ApplicationListener<ContextRefreshedEvent> {

    public static boolean isGameRun = false;

    public ApplicationListenerCompontent() {
        System.out.println(this.getClass().getName()+": start");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(this.getClass().getName()+": onApplicationEvent");
        isGameRun = true;
    }


}
