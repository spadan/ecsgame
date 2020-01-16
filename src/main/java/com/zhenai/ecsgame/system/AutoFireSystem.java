package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.*;
import com.zhenai.ecsgame.entity.BulletEntity;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;
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
public class AutoFireSystem extends AbstractSystemImpl {

    private int updateTimes;

    @Override
    public void gameUpdate() {
        autoFire();
        updateTimes++;
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(PositionComponent.class,
                ShapeComponent.class,
                BelongToComponent.class,
                AutoFireComponent.class);
    }


    /**
     * 自动开火
     */
    private void autoFire() {
        Collection<? extends IEntity> entities = getEntities();
        for (IEntity entity : entities) {
            AutoFireComponent fireComponent = entity.getComponent(AutoFireComponent.class);
            int frames = fireComponent.getFrames();
            if (updateTimes % frames == 0) {
                Direction direction = fireComponent.getDirection();
                Position position = entity.getComponent(PositionComponent.class).getPosition();
                Size size = entity.getComponent(ShapeComponent.class).getSize();
                int x, y;
                switch (direction) {
                    case UP:
                        x = position.getX() + ((size.getWidth() + Constant.BULLET_WIDTH) >> 2);
                        y = position.getY() - Constant.BULLET_HEIGHT;
                        break;
                    case DOWN:
                        x = position.getX() + ((size.getWidth() + Constant.BULLET_WIDTH) >> 2);
                        y = position.getY() + Constant.BULLET_HEIGHT;
                        break;
                    default:
                        continue;
                }
                int bullets = fireComponent.getBullets();
                for (int i = 0; i < bullets; i++) {
                    BulletEntity bullet = new BulletEntity();
                    bullet.addComponent(new PositionComponent(bullet, x, y));
                    bullet.addComponent(new MoveComponent(bullet, Integer.MAX_VALUE, direction, 2));
                    bullet.addComponent(new HealthComponent(bullet, 1));
                    bullet.addComponent(new DamageComponent(bullet, 1));
                    BelongToComponent belongToComponent = entity.getComponent(BelongToComponent.class);
                    int belongTo = belongToComponent.getBelongTo();
                    bullet.addComponent(new BelongToComponent(bullet, belongTo));
                    if (belongToComponent.isBelongToPlayer()) {
                        bullet.addComponent(new AccComponent(bullet, 20, 1));
                    }
                }
            }
        }
    }

}
