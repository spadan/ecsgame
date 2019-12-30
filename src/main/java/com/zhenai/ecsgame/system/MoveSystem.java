package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.entity.PositionEntity;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/15:26
 * @Description:
 */

@Component
public class MoveSystem extends AbstractSystemImpl {

    public MoveSystem(){
        super();
    }


    @Override
    public Collection<Class<? extends IEntity>> getRegisters() {
        return Arrays.asList(PositionEntity.class);
    }

    @Override
    public void GameUpdate() {
        //System.out.println(this.getClass().getName()+": GameUpdate ");
    }


}
