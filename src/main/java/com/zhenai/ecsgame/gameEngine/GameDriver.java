package com.zhenai.ecsgame.gameEngine;

import com.zhenai.ecsgame.component.IComponent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class GameDriver{

    private List<IGameObject> gameObjects = new CopyOnWriteArrayList();
    public GameDriver(){
        System.out.println("hello Component GameDriver");
        ExecutorService gameCoreThread =  Executors.newSingleThreadExecutor();
        gameCoreThread.submit(()->{
            int i = 0;
            while (true){
                Thread.sleep(100);
                i++;
                System.out.println(i);
                for (IGameObject gameObject : gameObjects) {
                    gameObject.update();
                }
            }
        });
    }




}
