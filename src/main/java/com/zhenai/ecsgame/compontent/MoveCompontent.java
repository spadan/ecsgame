package com.zhenai.ecsgame.compontent;

import com.zhenai.ecsgame.framwork.component.AbstractCompontent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Vector2D;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:23
 * @Description:
 */
public class MoveCompontent extends AbstractCompontent {

    /**
     * 移动剩余时间，单位：帧
     */
    private int animationTime;

    /**
     * 移动方向
     */
    private Vector2D vector;

    /**
     * 移动速度 = length/每帧time
     */
    private double moveSpeed;


    public MoveCompontent(IEntity compontent) {
        super(compontent);
        this.animationTime = 0;
        this.vector = new Vector2D();
        this.moveSpeed = 0;
    }

    public MoveCompontent(IEntity entity, int animationTime, Vector2D vector, double moveSpeed) {
        super(entity);
        this.animationTime = animationTime;
        this.vector = vector;
        this.moveSpeed = moveSpeed;
    }

    public int getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(int animationTime) {
        this.animationTime = animationTime;
    }

    public void addAnimationTime(int time){
        this.animationTime = this.animationTime+time;
    }

    public void reduceAnimaTime(){
        this.animationTime--;
    }

    public boolean isHaveMoveTime(){
        if (animationTime<=0){
            return false;
        }else {
            return true;
        }
    }

    public Vector2D getVector() {
        return vector;
    }

    public void setVector(Vector2D vector) {
        this.vector = vector;
    }

    public double getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
