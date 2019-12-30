package com.zhenai.ecsgame.entity;

import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.AbstractEntity;
import com.zhenai.ecsgame.framwork.entity.IEntity;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/15:57
 * @Description:
 */
public class PositionEntity extends AbstractEntity {

    private double x;
    private double y;


    public PositionEntity(IComponent compontent) {
        super(compontent);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
