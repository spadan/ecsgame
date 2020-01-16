package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.PlayerComponent;
import com.zhenai.ecsgame.entity.PlayerEntity;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * 玩家释放系统
 *
 * @author haitong.zhang
 * @date 2019/12/31/14:37
 */
@Component
@DependsOn(value = "entityManager")
public class PlayerReleaseSystem extends AbstractSystemImpl {

    @Override
    public void gameUpdate() {
        addPlayer();
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Collections.singletonList(PlayerComponent.class);
    }


    /**
     * 添加游戏用户
     */
    private void addPlayer() {
        Collection<? extends IEntity> entities = getEntities();
        if (entities.size() <= 0) {
            new PlayerEntity();
        }
    }

}
