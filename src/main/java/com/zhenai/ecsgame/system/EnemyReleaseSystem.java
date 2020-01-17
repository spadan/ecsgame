package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.entity.BigPlaneEntity;
import com.zhenai.ecsgame.entity.PlaneEntity;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * 机器人释放系统
 *
 * @author haitong.zhang
 * @date 2019/12/31/14:37
 */
@Component
@DependsOn(value = "entityManager")
public class EnemyReleaseSystem extends AbstractSystemImpl {

    private int updateTimes;

    @Override
    public void gameUpdate() {
        addNewRobot();
        updateTimes++;
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Collections.emptyList();
    }


    /**
     * 添加新的机器人
     */
    private void addNewRobot() {
        // 固定每60帧生成一个敌机，同时每帧都有2%的概率产生一个敌机
        int frames = 60;
        if (updateTimes % frames == 0 || RandomUtils.nextInt(0, 100) % 50 == 0) {
            if (RandomUtils.nextInt(0, 10) <= 2) {
                new BigPlaneEntity();
            } else {
                new PlaneEntity();
            }
        }
    }

}
