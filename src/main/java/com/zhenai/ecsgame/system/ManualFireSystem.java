package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.BelongToComponent;
import com.zhenai.ecsgame.component.ManualFireComponent;
import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.component.ShapeComponent;
import com.zhenai.ecsgame.entity.BulletEntity;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;

import java.util.Arrays;
import java.util.Collection;

/**
 * 手动开火系统
 *
 * @author haitong.zhang
 * @date 2019/12/31/14:37
 */
@Deprecated
public class ManualFireSystem extends AbstractSystemImpl {

    @Override
    public void gameUpdate() {
        fire();
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(PositionComponent.class,
                ShapeComponent.class,
                BelongToComponent.class,
                ManualFireComponent.class);
    }


    /**
     * 开火
     */
    private void fire() {
        Collection<? extends IEntity> entities = getEntities();
        for (IEntity entity : entities) {
            ManualFireComponent fireComponent = entity.getComponent(ManualFireComponent.class);
            int bullets = fireComponent.getBullets();
            if (bullets > 0) {
                Position position = entity.getComponent(PositionComponent.class).getPosition();
                Size size = entity.getComponent(ShapeComponent.class).getSize();
                int x = position.getX() + (size.getWidth() >> 2) + Constant.BULLET_WIDTH * 2;
                int y = position.getY() - Constant.BULLET_HEIGHT;
                for (int i = 0; i < bullets; i++) {
                    BulletEntity bullet = new BulletEntity(x, y);
                    int belongTo = entity.getComponent(BelongToComponent.class).getBelongTo();
                    bullet.addComponent(new BelongToComponent(bullet, belongTo));
                }
                fireComponent.setBullets(0);
            }
        }
    }

}
