package com.zhenai.ecsgame.framwork.gameEngine;

import com.zhenai.ecsgame.framwork.entity.IEntity;

import java.util.Collection;
import java.util.Observer;

public interface IEntityManager {

     void callAddEntity(IEntity entity);


     void callremoveEntity(IEntity entity);
     /**
      * 注册观察者
      * @param arr
      * @param sub
      */
     void registerListener(Collection<Class<? extends IEntity>> arr, Observer sub);

     /**
      * 注册观察者
      * @param entityClass
      * @param sub
      */
     void registerListener(Class<? extends IEntity> entityClass, Observer sub);
}
