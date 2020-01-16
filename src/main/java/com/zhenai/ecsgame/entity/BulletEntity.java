package com.zhenai.ecsgame.entity;

import com.zhenai.ecsgame.component.*;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.entity.AbstractEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:58
 * @Description:机器人
 */
public class BulletEntity extends AbstractEntity {

    private static String bulletImageName = "bullet";

    public BulletEntity() {
        super();
        ShapeComponent shape = new ShapeComponent(this, Constant.BULLET_WIDTH, Constant.BULLET_HEIGHT, bulletImageName);
        addComponent(shape);
    }

    public BulletEntity(int startX, int startY) {
        super();
        HealthComponent health = new HealthComponent(this, 1);
        DamageComponent damage = new DamageComponent(this, 1);
        ShapeComponent shape = new ShapeComponent(this, Constant.BULLET_WIDTH, Constant.BULLET_HEIGHT, bulletImageName);
        PositionComponent startPosition = new PositionComponent(this, startX, startY);
        MoveComponent move = new MoveComponent(this, Integer.MAX_VALUE,
                Direction.UP, 3);
        AccComponent acc = new AccComponent(this, Constant.FRAME_SPEED, 2);
        addComponent(shape)
                .addComponent(health)
                .addComponent(damage)
                .addComponent(startPosition)
                .addComponent(move)
                .addComponent(acc);
    }


    public void setSpeed(int speed) {
        getComponent(MoveComponent.class).setMoveSpeed(speed);
    }

    public void setDirection(Direction v) {
        getComponent(MoveComponent.class).setDirection(v);
    }

    public void setAnimationTime(int time) {
        getComponent(MoveComponent.class).setAnimationTime(time);
    }

}
