package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.component.ShapeComponent;
import com.zhenai.ecsgame.component.PlayerComponent;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;
import com.zhenai.ecsgame.framwork.gameEngine.util.EngineUtils;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * 出界检测系统
 *
 * @author haitong.zhang
 * @date 2019/12/30/15:26
 */

@Component
@DependsOn(value = "entityManager")
public class OutboundCheckSystem extends AbstractSystemImpl {


    public OutboundCheckSystem() {
        super();
    }


    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(PositionComponent.class, ShapeComponent.class);
    }

    @Override
    public void gameUpdate() {
        Collection<? extends IEntity> entities = getEntities();
        for (IEntity entity : entities) {
            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            ShapeComponent shapeComponent = entity.getComponent(ShapeComponent.class);
            Position position = positionComponent.getPosition();
            Size size = shapeComponent.getSize();
            if (!shouldSkip(entity) && EngineUtils.isOutbound(position, size)) {
                entity.destroy();
            }
        }
    }

    private boolean shouldSkip(IEntity entity) {
        PlayerComponent userComponent = entity.getComponent(PlayerComponent.class);
        return userComponent != null;
    }
}
