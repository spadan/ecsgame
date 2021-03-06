package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.OutboundOkComponent;
import com.zhenai.ecsgame.component.ImageComponent;
import com.zhenai.ecsgame.component.PositionComponent;
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
        return Arrays.asList(PositionComponent.class, ImageComponent.class);
    }

    @Override
    public void gameUpdate() {
        Collection<? extends IEntity> entities = getEntities();
        for (IEntity entity : entities) {
            PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
            ImageComponent outlineComponent = entity.getComponent(ImageComponent.class);
            Position position = positionComponent.getPosition();
            Size size = outlineComponent.getSize();
            if (EngineUtils.isOutbound(position, size) && !entity.isContainComponent(OutboundOkComponent.class)) {
                entity.destroy();
            }
        }
    }
}
