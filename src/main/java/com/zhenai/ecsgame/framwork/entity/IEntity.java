package com.zhenai.ecsgame.framwork.entity;

import com.zhenai.ecsgame.framwork.component.IComponent;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;


public interface IEntity {

    /**
     * 获取Compontent 组件
     * @param clz
     * @return
     */
    <T extends IComponent> T getComponent(Class<T> clz);

    IComponent getComponent(String clzName);

    <T extends IComponent> IEntity addComponent(T t);

    void removeCompontent(Class<? extends IComponent> clz);

    void clearAllCompontents();

    boolean isContainCompontents(Collection<Class<? extends IComponent>>clzs);

    boolean isContainComponent(Class<? extends IComponent> clz);

    void destroy();

    /**
     * 获取id
     * @return
     */
    UUID getEntityID();

    LocalDateTime getCreateTime();

}
