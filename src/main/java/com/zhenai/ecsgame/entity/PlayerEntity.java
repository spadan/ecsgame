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
public class PlayerEntity extends AbstractEntity {

    private static String playerImageName="player";

    public PlayerEntity() {
        super();
        PlayerComponent user = new PlayerComponent(this);
        BelongToComponent belongTo = new BelongToComponent(this, BelongToComponent.PLAYER);
        HealthComponent health = new HealthComponent(this, 3);
        DamageComponent damage = new DamageComponent(this, Integer.MAX_VALUE);
        ShapeComponent shape = new ShapeComponent(this, Constant.PLAYER_WIDTH, Constant.PLAYER_HEIGHT, playerImageName);
        PositionComponent startPosition = new PositionComponent(this
                , (Constant.BOARD_WIDTH - Constant.PLAYER_WIDTH) >> 2
                , Constant.BOARD_HEIGHT - Constant.PLAYER_HEIGHT);
        AutoFireComponent autoFire = new AutoFireComponent(this, 10, 1, Direction.UP);
        addComponent(user)
                .addComponent(belongTo)
                .addComponent(health)
                .addComponent(damage)
                .addComponent(shape)
                .addComponent(startPosition)
                .addComponent(autoFire);
    }


    public void setSpeed(int speed) {
        getComponent(MoveComponent.class).setMoveSpeed(speed);
    }

    public void setVector(Direction v) {
        getComponent(MoveComponent.class).setDirection(v);
    }

    public void setAnimationTime(int time) {
        getComponent(MoveComponent.class).setAnimationTime(time);
    }
}
