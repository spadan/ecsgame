package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.AccComponent;
import com.zhenai.ecsgame.component.MoveComponent;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * 加速系统
 *
 * @author haitong.zhang
 * @date 2019/12/31/14:37
 */
@Component
@DependsOn(value = "entityManager")
public class SpeedUpSystem extends AbstractSystemImpl {

    private int updateTimes;

    @Override
    public void gameUpdate() {
        speedUp();
        updateTimes++;
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(MoveComponent.class, AccComponent.class);
    }


    /**
     * 加速
     */
    private void speedUp() {
        Collection<? extends IEntity> entities = getEntities();
        for (IEntity entity : entities) {
            MoveComponent moveComponent = entity.getComponent(MoveComponent.class);
            AccComponent accComponent = entity.getComponent(AccComponent.class);
            if (updateTimes % accComponent.getFrames() == 0) {
                moveComponent.setMoveSpeed(moveComponent.getMoveSpeed() + accComponent.getAcc());
            }
        }

    }

}
