package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.MoveComponent;
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
 * 移动系统
 *
 * @author haitong.zhang
 * @date 2019/12/30/15:26
 */

@Component
@DependsOn(value = "entityManager")
public class MoveSystem extends AbstractSystemImpl {

    public MoveSystem() {
        super();
    }


    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(PositionComponent.class, MoveComponent.class);
    }

    @Override
    public void gameUpdate() {
        Collection<? extends IEntity> entities = getEntities();
        entities.forEach(this::move);
    }

    /**
     * 移动操作
     */
    private void move(IEntity entity) {
        MoveComponent moveComponent = entity.getComponent(MoveComponent.class);
        if (moveComponent.isHaveMoveTime()) {
            PositionComponent startPositionComponent = entity.getComponent(PositionComponent.class);
            Position startPosition = startPositionComponent.getPosition();
            Position endPosition = EngineUtils.getEndPosition(moveComponent.getDirection(), startPosition, moveComponent.getMoveSpeed());
            if (shouldStop(entity, endPosition)) {
                moveComponent.setAnimationTime(0);
                return;
            }
            startPositionComponent.setPosition(endPosition);
            moveComponent.reduceAnimaTime();
        }
    }

    /**
     * 玩家移动到边界检测
     *
     * @param entity
     * @param position
     * @return
     */
    private boolean shouldStop(IEntity entity, Position position) {
        PlayerComponent userComponent = entity.getComponent(PlayerComponent.class);
        if (userComponent != null) {
            ShapeComponent shapeComponent = entity.getComponent(ShapeComponent.class);
            if (shapeComponent != null) {
                Size size = shapeComponent.getSize();
                if (EngineUtils.isOutbound(position, size)) {
                    return true;
                }
            }
        }
        return false;
    }


}
