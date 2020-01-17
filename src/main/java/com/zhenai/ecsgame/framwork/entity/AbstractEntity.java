package com.zhenai.ecsgame.framwork.entity;

import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.gameEngine.IEntityManager;
import com.zhenai.ecsgame.framwork.gameEngine.util.BeanUtils;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractEntity implements IEntity {


    /**
     * id
     */
    private UUID entity_id = null;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    IEntityManager entityManager;

    public AbstractEntity() {
        entity_id = UUID.randomUUID();
        createTime = LocalDateTime.now();
        entityManager = BeanUtils.getBean(IEntityManager.class);
        entityManager.onCreatEntity(this);
    }

    @Override
    public UUID getEntityID() {
        return entity_id;
    }

    @Override
    public void destroy() {
        entityManager.onRemoveEntity(this);
    }

    private Map<String, IComponent> compontentMap = new HashMap<>();


    @Override
    public <T extends IComponent> T getComponent(Class<T> clz) {
        if (compontentMap.containsKey(clz.getName())) {
            return (T) compontentMap.get(clz.getName());
        } else {
            return null;
        }
    }

    @Override
    public IComponent getComponent(String clzName) {
        return compontentMap.get(clzName);
    }

    @Override
    public <T extends IComponent> IEntity addComponent(T t) {
        compontentMap.put(t.getClass().getName(), t);
        return this;
    }


    @Override
    public void removeCompontent(Class<? extends IComponent> t) {
        if (compontentMap.containsKey(t.getName())) {
            compontentMap.remove(t.getName());
        }
    }


    @Override
    public void clearAllCompontents() {
        compontentMap.clear();
    }


    @Override
    public boolean isContainCompontents(Collection<Class<? extends IComponent>> clzs) {
        if (clzs == null || clzs.size() == 0) {
            return false;
        }
        boolean result = true;
        for (Class<? extends IComponent> clz : clzs) {
            if (!compontentMap.containsKey(clz.getName())) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean isContainComponent(Class<? extends IComponent> clz) {
        return clz != null && compontentMap.containsKey(clz.getName());
    }

    @Override
    public LocalDateTime getCreateTime() {
        return createTime;
    }
}
