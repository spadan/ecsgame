package com.zhenai.ecsgame;

import com.zhenai.ecsgame.Manager.RobotManager;
import com.zhenai.ecsgame.framwork.gameEngine.util.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EcsgameApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(EcsgameApplication.class, args);
        BeanUtils.applicationContext = applicationContext;
        new RobotManager();
    }


}
