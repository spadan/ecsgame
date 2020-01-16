package com.zhenai.ecsgame.framwork.gameEngine;


import com.zhenai.ecsgame.framwork.constant.Constant;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class GameDriver implements IGameDriver, ApplicationRunner {

    private List<IGameObject> gameObjects = new CopyOnWriteArrayList<>();


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ExecutorService gameCoreThread = Executors.newSingleThreadExecutor();
        gameCoreThread.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000 / Constant.FRAME_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                removeObj();
                for (IGameObject gameObject : gameObjects) {
                    gameObject.gameUpdate();
                }
            }
        });
    }

    public GameDriver() {
        System.out.println(this.getClass().getName() + " : start");
    }


    @Override
    public void addObj(IGameObject object) {
        gameObjects.add(object);
    }

    @Override
    public void removeObj() {
        Set<IGameObject> removeSet = new HashSet<>();
        gameObjects.forEach(e -> {
            if (e.getGameState() == IGameObject.GameState.STATE_END) {
                removeSet.add(e);
            }
        });
        gameObjects.removeIf(removeSet::contains);
    }


}
