package com.zhenai.ecsgame.system;

import com.google.common.collect.Sets;
import com.zhenai.ecsgame.component.*;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.BelongTo;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;
import com.zhenai.ecsgame.framwork.gameEngine.util.EngineUtils;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 碰撞后伤害结算系统
 *
 * @author haitong.zhang
 * @date 2019/12/31/14:37
 */
@Component
@DependsOn(value = "entityManager")
public class DamageCheckSystem extends AbstractSystemImpl {

    @Override
    public void gameUpdate() {
        checkHit();
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(DamageComponent.class,
                HealthComponent.class,
                PositionComponent.class,
                ImageComponent.class,
                BelongToComponent.class);
    }


    /**
     * 碰撞检测
     */
    private void checkHit() {
        Collection<? extends IEntity> entities = getEntities();
        Map<BelongTo, ? extends List<? extends IEntity>> groupMap;
        groupMap = entities.stream()
                           .filter(e -> !e.isContainCompontents(Collections.singletonList(ToCleanComponent.class)))
                           .collect(Collectors.groupingBy(e -> e.getComponent(BelongToComponent.class).getBelongTo()));

        List<? extends IEntity> players = groupMap.get(BelongTo.PLAYER);
        List<? extends IEntity> enemies = groupMap.get(BelongTo.ENEMY);
        if (players == null || enemies == null) {
            return;
        }
        Set<IEntity> collision = Sets.newHashSet();
        for (IEntity entity1 : players) {
            if (collision.contains(entity1)) {
                continue;
            }
            for (IEntity entity2 : enemies) {
                if (collision.contains(entity2)) {
                    continue;
                }
                Position position1 = entity1.getComponent(PositionComponent.class).getPosition();
                Size size1 = entity1.getComponent(ImageComponent.class).getSize();
                Position position2 = entity2.getComponent(PositionComponent.class).getPosition();
                Size size2 = entity2.getComponent(ImageComponent.class).getSize();
                if (EngineUtils.isCollisionWithRect(position1, size1, position2, size2)) {
                    collision.add(entity1);
                    collision.add(entity2);
                    calDamage(entity1, entity2);
                    calDamage(entity2, entity1);
                }
            }
        }
    }

    private void calDamage(IEntity entity1, IEntity entity2) {
        HealthComponent health1 = entity1.getComponent(HealthComponent.class);
        int hp1 = health1.getHp();
        int damage2 = entity2.getComponent(DamageComponent.class).getDamage();
        // 被摧毁
        int resultHp = Math.max(hp1 - damage2, 0);
        health1.setHp(resultHp);
        if (resultHp <= 0) {
            if (entity1.isContainComponent(PlaneComponent.class) || entity1.isContainComponent(BigPlaneComponent.class)) {
                // 飞机被击毁后，延迟10帧再销毁，留出时间展示被击毁形象
                entity1.addComponent(new ToCleanComponent(entity1, 10));
            } else if (entity1.isContainComponent(BulletComponent.class)) {
                entity1.destroy();
            }
        }
    }

}
