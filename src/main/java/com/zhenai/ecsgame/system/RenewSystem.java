package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.component.RenewComponent;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * 清理系统
 *
 * @author haitong.zhang
 * @date 2019/12/31/14:37
 */
@Component
@DependsOn(value = "entityManager")
public class RenewSystem extends AbstractSystemImpl {


    @Override
    public void gameUpdate() {
        renew();
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(RenewComponent.class, PositionComponent.class);
    }


    /**
     * 出界后重新出现
     */
    private void renew() {
        Collection<? extends IEntity> entities = getEntities();
        for (IEntity entity : entities) {
            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            Position position = positionComponent.getPosition();
            if (position.getY() >= Constant.BOARD_HEIGHT) {
                RenewComponent renewComponent = entity.getComponent(RenewComponent.class);
                positionComponent.setPosition(Position.cloneNew(renewComponent.getPosition()));
            }
        }
    }

}
