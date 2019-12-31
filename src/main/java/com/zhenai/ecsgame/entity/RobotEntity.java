package com.zhenai.ecsgame.entity;

import com.zhenai.ecsgame.compontent.MoveCompontent;
import com.zhenai.ecsgame.compontent.PositionCompontent;
import com.zhenai.ecsgame.framwork.entity.AbstractEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Vector2D;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:58
 * @Description:机器人
 */
public class RobotEntity extends AbstractEntity {


    public RobotEntity(){
        super();
        MoveCompontent moveCompontent = new MoveCompontent(this);
        moveCompontent.setMoveSpeed(1.0d);
        moveCompontent.setVector(new Vector2D(1,1));
        moveCompontent.setAnimationTime(100);
        addCompontent(moveCompontent);
        addCompontent(new PositionCompontent(this));
    }

    public void setSpeed(double speed){
        getCompontent(MoveCompontent.class).setMoveSpeed(speed);
    }

    public void setVector(Vector2D v){
        getCompontent(MoveCompontent.class).setVector(v);
    }

    public void setAnimationTime(int time){
        getCompontent(MoveCompontent.class).setAnimationTime(time);
    }



}
