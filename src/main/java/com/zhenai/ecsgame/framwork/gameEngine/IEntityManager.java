package com.zhenai.ecsgame.framwork.gameEngine;

import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;

import java.util.Collection;


/**
 * 实体管理类
 */
public interface IEntityManager {

    <T extends IEntity> void onCreatEntity(T entity);

    <T extends IEntity> void onRemoveEntity(T entity);

    Collection<IEntity> getFilterEntity(Collection<Class<? extends IComponent>> clzs);
}
