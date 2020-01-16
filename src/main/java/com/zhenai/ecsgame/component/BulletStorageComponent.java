package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;

/**
 * @Auther: haitong.zhang
 * @Date: 2020/01/03/10:51
 * @Description:弹药容量信息模块
 */
public class BulletStorageComponent extends AbstractComponent {

    private int capacity;

    public BulletStorageComponent(IEntity entity) {
        super(entity);
    }

    public BulletStorageComponent(IEntity entity,int capacity) {
        super(entity);
        this.capacity = capacity;
    }
}
