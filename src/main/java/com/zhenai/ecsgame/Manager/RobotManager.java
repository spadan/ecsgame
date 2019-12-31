package com.zhenai.ecsgame.Manager;

import com.zhenai.ecsgame.ApplicationListenerCompontent;
import com.zhenai.ecsgame.compontent.MoveCompontent;
import com.zhenai.ecsgame.compontent.PositionCompontent;
import com.zhenai.ecsgame.entity.RobotEntity;
import com.zhenai.ecsgame.framwork.gameEngine.AbstractGameObject;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Vector2D;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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


        if (updateTime%10==0){
            printPosition(robotEntities);
        }

    }

    /**
     * 增加机器人移动时间
     */
    private void addRobotAnimationTime(){
        robotEntities.forEach(e->{
            MoveCompontent compontent = e.getCompontent(MoveCompontent.class);
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
            PositionCompontent compontent =  e.getCompontent(PositionCompontent.class);
            if (compontent!=null){
                System.out.print(compontent.getPosition()+":::::");
            }

        });
        System.out.println();
    }
}
