package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.compontent.MoveCompontent;
import com.zhenai.ecsgame.compontent.PositionCompontent;
import com.zhenai.ecsgame.framwork.component.ICompontent;
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
    public Collection<Class<? extends ICompontent>> interestCompontent() {
        return Arrays.asList(PositionCompontent.class, MoveCompontent.class);
    }

    @Override
    public void GameUpdate() {
        Collection<? extends IEntity> entities = getEntities();
        entities.forEach(e->move(e));
    }

    private void printPosition(Collection<IEntity> collections){
        collections.forEach(e-> {
            PositionCompontent compontent =  e.getCompontent(PositionCompontent.class);
            System.out.println(compontent.getPosition());
        });
    }

    /**
     * 移动操作
     * @param entity
     */
    private void move(IEntity entity){
        MoveCompontent moveCompontent = entity.getCompontent(MoveCompontent.class);

        if (moveCompontent.isHaveMoveTime()){
            PositionCompontent position =  entity.getCompontent(PositionCompontent.class);
            Position resultPostion = EngineUtils.getResultPostion(moveCompontent.getVector(),position.getPosition(),moveCompontent.getMoveSpeed());
            position.setPosition(resultPostion);
            moveCompontent.reduceAnimaTime();
        }

    }



}
