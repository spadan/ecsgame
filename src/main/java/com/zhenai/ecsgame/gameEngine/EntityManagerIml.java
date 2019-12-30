package com.zhenai.ecsgame.gameEngine;

import com.zhenai.ecsgame.entity.IEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EntityManagerIml  implements IEntityManager {



    private Map<String,Observable> observableMap = new HashMap();

    @Override
    public void callAddEntity(IEntity entity) {
        if (entity != null&&observableMap.containsKey(entity.getClass().getName())){
            observableMap.get(entity.getClass().getName()).notifyObservers(entity);
        }
    }

    @Override
    public void registerListener(List<Class<IEntity>> arr, Observer sub) {
        for (Class aClass : arr) {
            String listenerName = aClass.getName();
            if (observableMap.containsKey(listenerName)){
               Observable observable =  observableMap.get(listenerName);
               observable.addObserver(sub);
            }else {
                Observable able = new Observable();
                observableMap.put(listenerName,able);
                able.addObserver(sub);
            }
        }
    }



}
