package com.zhenai.ecsgame.framwork.component;

import com.zhenai.ecsgame.framwork.entity.IEntity;


/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/16:26
 * @Description:
 */
public abstract class AbstractComponent implements IComponent {

    private IEntity entity;

    public AbstractComponent(IEntity entity) {
        this.entity = entity;
    }

    @Override
    public IEntity getEntity() {
        return this.entity;
    }
}
