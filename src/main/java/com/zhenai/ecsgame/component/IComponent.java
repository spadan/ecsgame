package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.entity.IEntity;
import com.zhenai.ecsgame.gameEngine.IGameObject;

import java.util.HashMap;
import java.util.Map;

public interface IComponent extends IGameObject {

    Map<String,IEntity> entities = new HashMap<>();

    /**
     * 获取entity 组件
     * @param clz
     * @return
     */
    IEntity getEntity(Class clz);

    IEntity getEntity(String clzName);


    <T> void addEntity(T t);

    <T> T removeEntity();

    void clearAllEntities();

}
