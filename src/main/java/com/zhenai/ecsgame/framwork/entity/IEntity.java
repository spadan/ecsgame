package com.zhenai.ecsgame.framwork.entity;

import com.zhenai.ecsgame.framwork.component.ICompontent;

import java.util.Collection;

public interface IEntity {



    /**
     * 获取Compontent 组件
     * @param clz
     * @return
     */
    <T extends ICompontent> T getCompontent(Class<T> clz);

    ICompontent getCompontent(String clzName);

    <T extends ICompontent> IEntity addCompontent(T t);

    void removeCompontent(Class<? extends ICompontent> clz);

    void clearAllCompontents();

    boolean isContainCompontents(Collection<Class<? extends ICompontent>>clzs);

    void destroy();

}
