package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:23
 * @Description:
 */
public class MoveComponent extends AbstractComponent {

    /**
     * 移动剩余时间，单位：帧
     */
    private int animationTime;

    /**
     * 移动方向
     */
    private Direction direction;

    /**
     * 移动速度 = length/每帧time
     */
    private int moveSpeed;

    public MoveComponent(IEntity entity, int animationTime, Direction vector, int moveSpeed) {
        super(entity);
        this.animationTime = animationTime;
        this.direction = vector;
        this.moveSpeed = moveSpeed;
    }

    public int getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(int animationTime) {
        this.animationTime = animationTime;
    }

    public void addAnimationTime(int time) {
        this.animationTime = this.animationTime + time;
    }

    public void reduceAnimaTime() {
        this.animationTime--;
    }

    public boolean isHaveMoveTime() {
        if (animationTime <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
