package com.zhenai.ecsgame.entity;

import com.zhenai.ecsgame.component.MoveComponent;
import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.component.UserInfoComponent;
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
        UserInfoComponent uc= new UserInfoComponent(this,
                "robot"+this.getEntityID().hashCode()%1000
                ,this.getEntityID().toString()
                ,UserInfoComponent.UserType.Robot);

        MoveComponent mc = new MoveComponent(this,100,Vector2D.getRandomVector(),1.0d);
        addCompontent(mc).addCompontent(uc).addCompontent(new PositionComponent(this));

    }

    public void setSpeed(double speed){
        getCompontent(MoveComponent.class).setMoveSpeed(speed);
    }

    public void setVector(Vector2D v){
        getCompontent(MoveComponent.class).setVector(v);
    }

    public void setAnimationTime(int time){
        getCompontent(MoveComponent.class).setAnimationTime(time);
    }

}
