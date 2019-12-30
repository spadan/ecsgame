package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.entity.IEntity;

public abstract class AbstractComponent implements IComponent{

    @Override
    public IEntity getEntity(Class clz) {
        return entities.get(clz.getName());
    }

    @Override
    public IEntity getEntity(String clzName) {
        return entities.get(clzName);
    }

    @Override
    public <T> void addEntity(T t) {

    }

    @Override
    public <T> T removeEntity() {
        return null;
    }

    @Override
    public void clearAllEntities() {

    }
}
