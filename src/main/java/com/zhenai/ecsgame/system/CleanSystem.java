package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.ToCleanComponent;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
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
public class CleanSystem extends AbstractSystemImpl {


    @Override
    public void gameUpdate() {
        doClean();
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(ToCleanComponent.class);
    }


    /**
     * 自动开火
     */
    private void doClean() {
        Collection<? extends IEntity> entities = getEntities();
        for (IEntity entity : entities) {
            ToCleanComponent toCleanComponent = entity.getComponent(ToCleanComponent.class);
            int frames = toCleanComponent.getFrames();
            if (frames <= 0) {
                entity.destroy();
            } else {
                toCleanComponent.setFrames(frames - 1);
            }
        }
    }

}
