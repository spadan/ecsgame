package com.zhenai.ecsgame.Manager;

import com.zhenai.ecsgame.component.MoveComponent;
import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.component.UserInfoComponent;
import com.zhenai.ecsgame.entity.RobotEntity;
import com.zhenai.ecsgame.framwork.gameEngine.AbstractGameObject;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Vector2D;


import java.util.ArrayList;
import java.util.Collection;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/14:37
 * @Description:机器人管理类
 */

public class RobotManager extends AbstractGameObject {

    private final int robotNum = 2;

    private int updateTime = 0;

    Collection<RobotEntity> robotEntities = new ArrayList<>();

    @Override
    public void GameUpdate() {

        updateTime++;
        addNewRobot();
        addRobotAnimationTime();

        if (updateTime%100==0){
            printPosition(robotEntities);
        }
    }


    /**
     * 增加机器人移动时间
     */
    private void addRobotAnimationTime(){
        robotEntities.forEach(e->{
            MoveComponent compontent = e.getCompontent(MoveComponent.class);
            if (compontent.getAnimationTime()==0){
                compontent.addAnimationTime(100);
            }
        });
    }

    /**
     * 添加新的机器人
     */
    private void addNewRobot(){
        if (robotEntities.size()<robotNum){
            RobotEntity entity = new RobotEntity();
            entity.setVector(Vector2D.getRandomVector());
            entity.setSpeed(0.01);
            robotEntities.add(entity);
        }
    }

    private void printPosition(Collection<RobotEntity> collections){
        collections.forEach(e-> {
            PositionComponent pc =  e.getCompontent(PositionComponent.class);
            UserInfoComponent uc =  e.getCompontent(UserInfoComponent.class);
            if (pc!=null&&uc!=null){
                System.out.print("id:"+uc.getUserName()+"{"+pc.getPosition()+"},");
            }
        });
        System.out.println();
    }
}
