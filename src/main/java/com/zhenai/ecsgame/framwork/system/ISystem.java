package com.zhenai.ecsgame.framwork.system;

import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.IGameObject;

import java.util.Collection;


public interface ISystem extends IGameObject{

    public Collection<? extends IEntity> getEntities();

}
