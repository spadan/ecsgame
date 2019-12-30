package com.zhenai.ecsgame.gameEngine;

import com.zhenai.ecsgame.entity.IEntity;

import java.util.List;
import java.util.Observer;

public interface IEntityManager {

     void callAddEntity(IEntity entity);

     /**
      * 注册观察者
      * @param arr
      * @param sub
      */
     void registerListener(List<Class<IEntity>> arr, Observer sub);
}
