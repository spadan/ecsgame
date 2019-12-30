package com.zhenai.ecsgame.framwork.entity;

import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.gameEngine.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/16:26
 * @Description:
 */
public abstract class AbstractEntity implements IEntity {

    private IComponent component;

    @Autowired
    private EntityManager entityManager;

    public AbstractEntity(IComponent compontent) {
        this.component = compontent;
        entityManager.callAddEntity(this);
    }

    @Override
    public IComponent getCompontent() {
        return this.component;
    }
}
