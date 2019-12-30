package com.zhenai.ecsgame.framwork.component;

import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.IGameObject;

import java.util.HashMap;
import java.util.Map;

public interface IComponent extends IGameObject{



    /**
     * 获取entity 组件
     * @param clz
     * @return
     */
    IEntity getEntity(Class clz);

    IEntity getEntity(String clzName);


    <T extends IEntity> void addEntity(T t);

    <T extends IEntity> void removeEntity(T t);

    void clearAllEntities();

}
