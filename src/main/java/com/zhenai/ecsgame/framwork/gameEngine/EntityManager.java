package com.zhenai.ecsgame.framwork.gameEngine;

import com.zhenai.ecsgame.framwork.entity.IEntity;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.*;

@Component()
@DependsOn("gameDriver")
public class EntityManager implements IEntityManager {

    public EntityManager(){
        System.out.println(this.getClass().getName()+" : start");
    }


    private Map<String,Observable> observableMap = new HashMap();
    @Override
    public synchronized void callAddEntity(IEntity entity) {
        if (entity != null&&observableMap.containsKey(entity.getClass().getName())){
            observableMap.get(entity.getClass().getName()).notifyObservers(new NotifyBean(NotifyBean.Opt.Notify_Add,entity));
        }
    }

    @Override
    public void callremoveEntity(IEntity entity) {
        if (entity != null&&observableMap.containsKey(entity.getClass().getName())){
            observableMap.get(entity.getClass().getName()).notifyObservers(new NotifyBean(NotifyBean.Opt.Notify_Remove,entity));
        }
    }

    @Override
    public void registerListener(Collection<Class<? extends IEntity>> arr, Observer sub) {
        for (Class enclz : arr) {
            registerListener(enclz,sub);
        }
    }

    @Override
    public void registerListener(Class<? extends IEntity> entityClass, Observer sub) {
        if (entityClass!=null && sub!=null){
            String listenerName = entityClass.getName();
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
