package com.zhenai.ecsgame.framwork.entity;

import com.zhenai.ecsgame.framwork.component.IComponent;

import java.util.Collection;
import java.util.UUID;


public interface IEntity {

    /**
     * 获取Compontent 组件
     * @param clz
     * @return
     */
    <T extends IComponent> T getCompontent(Class<T> clz);

    IComponent getCompontent(String clzName);

    <T extends IComponent> IEntity addCompontent(T t);

    void removeCompontent(Class<? extends IComponent> clz);

    void clearAllCompontents();

    boolean isContainCompontents(Collection<Class<? extends IComponent>>clzs);

    void destroy();

    /**
     * 获取id
     * @return
     */
    UUID getEntityID();

}
