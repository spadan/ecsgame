package com.zhenai.ecsgame.framwork.gameEngine;

import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@Component()
@DependsOn("gameDriver")
public class EntityManager implements IEntityManager {

    public EntityManager() {
        System.out.println(this.getClass().getName() + " : start");
    }

    Collection<IEntity> entities = new CopyOnWriteArraySet<>();


    @Override
    public <T extends IEntity> void onCreatEntity(T entity) {
        entities.add(entity);
    }

    @Override
    public <T extends IEntity> void onRemoveEntity(T entity) {
        if (entity != null && entities.contains(entity)) {
            entities.remove(entity);
        }
    }


    @Override
    public Collection<IEntity> getFilterEntity(Collection<Class<? extends IComponent>> clzs) {
        if (clzs == null || clzs.size() == 0) {
            return new ArrayList<>(entities);
        }
        Collection<IEntity> resultEntities = new ArrayList<>();
        entities.forEach(e -> {
            if (e.isContainCompontents(clzs)) {
                resultEntities.add(e);
            }
        });
        return resultEntities;
    }
}


