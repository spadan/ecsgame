package com.zhenai.ecsgame.framwork.component;

import com.zhenai.ecsgame.framwork.entity.IEntity;


/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/16:26
 * @Description:
 */
public abstract class AbstractCompontent implements ICompontent {

    private IEntity entity;

    public AbstractCompontent(IEntity entity) {
        this.entity = entity;
    }

    @Override
    public IEntity getEntity() {
        return this.entity;
    }
}
