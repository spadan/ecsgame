package com.zhenai.ecsgame.framwork.component;

import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.EntityManager;
import com.zhenai.ecsgame.framwork.gameEngine.GameDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractComponent  implements IComponent{

    private Map<String,IEntity> entities = new HashMap<>();

    @Autowired
    private GameDriver gameDriver;

    @Autowired
    private EntityManager entityManager;

    private GameState state;

    public AbstractComponent(){
        gameDriver.addObj(this);
    }



    @Override
    public IEntity getEntity(Class clz) {
        return entities.get(clz.getName());
    }

    @Override
    public IEntity getEntity(String clzName) {
        return entities.get(clzName);
    }

    @Override
    public <T extends IEntity> void addEntity(T t) {
        entities.put(t.getClass().getName(),t);
        entityManager.callAddEntity(t);
    }

    @Override
    public <T extends IEntity> void removeEntity(T t) {
        if (entities.containsKey(t)){
            entityManager.callremoveEntity(t);
            entities.remove(t.getClass().getName());
        }
    }

    @Override
    public void GameUpdate() {

    }

    @Override
    public void clearAllEntities() {
        entities.entrySet().forEach(e->entityManager.callremoveEntity(e.getValue()));
        entities.clear();
    }

    @Override
    public void destory() {
        clearAllEntities();
        setGameState(GameState.STATE_END);
    }

    @Override
    public GameState getGameState() {
        return state;
    }

    @Override
    public void setGameState(GameState state) {
        this.state = state;
    }
}
