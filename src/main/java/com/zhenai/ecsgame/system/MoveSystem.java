package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.MoveComponent;
import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.util.EngineUtils;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/15:26
 * @Description:
 */

@Component
@DependsOn(value = "entityManager")
public class MoveSystem extends AbstractSystemImpl {

    public MoveSystem(){
        super();
    }


    @Override
    public Collection<Class<? extends IComponent>> interestCompontent() {
        return Arrays.asList(PositionComponent.class, MoveComponent.class);
    }

    @Override
    public void GameUpdate() {
        Collection<? extends IEntity> entities = getEntities();
        entities.forEach(e->move(e));
    }

    /**
     * 移动操作
     * @param entity
     */
    private void move(IEntity entity){
        MoveComponent moveComponent = entity.getCompontent(MoveComponent.class);
        if (moveComponent.isHaveMoveTime()){
            PositionComponent position =  entity.getCompontent(PositionComponent.class);
            Position resultPostion = EngineUtils.getResultPostion(moveComponent.getVector(),position.getPosition(), moveComponent.getMoveSpeed());
            position.setPosition(resultPostion);
            moveComponent.reduceAnimaTime();
        }
    }







}
