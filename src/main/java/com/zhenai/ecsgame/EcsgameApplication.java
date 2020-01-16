package com.zhenai.ecsgame;

import com.zhenai.ecsgame.framwork.gameEngine.util.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EcsgameApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(EcsgameApplication.class, args);
        BeanUtils.applicationContext = applicationContext;
    }

    private static void initManager(){
//        new RobotManager();
       /* NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("localhost",8088));*/
    }


}
