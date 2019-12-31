package com.zhenai.ecsgame.framwork.gameEngine;



import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class GameDriver implements IGameDriver{


    /**
     * 每秒多少帧
     */
    private int framSpeed = 30;

    private List<IGameObject> gameObjects = new CopyOnWriteArrayList();
    public GameDriver(){
        System.out.println(this.getClass().getName() + " : start");
    }
    @PostConstruct
    public void init(){
        ExecutorService gameCoreThread =  Executors.newSingleThreadExecutor();
        gameCoreThread.execute(()->{
            while (true){
                try {
                    Thread.sleep(1000/framSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removeObj();
                for (IGameObject gameObject : gameObjects) {
                    gameObject.GameUpdate();
                }
            }
        });
    }

    @Override
    public void addObj(IGameObject object) {
        gameObjects.add(object);
    }

    @Override
    public void removeObj() {
        Set<IGameObject> removeSet = new HashSet();
        gameObjects.forEach(e->{
            if (e.getGameState()== IGameObject.GameState.STATE_END){
                removeSet.add(e);
            }
        });
        gameObjects.removeIf(e->removeSet.contains(e));
    }


}
