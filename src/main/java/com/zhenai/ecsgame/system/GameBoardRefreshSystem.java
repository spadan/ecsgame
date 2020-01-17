package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.ImageComponent;
import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.GameBoard;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * 游戏界面刷新系统
 *
 * @author haitong.zhang
 * @date 2019/12/30/15:26
 */

@Component
@DependsOn(value = "entityManager")
public class GameBoardRefreshSystem extends AbstractSystemImpl{

    private GameBoard gameBoard;

    @Autowired
    public GameBoardRefreshSystem(GameBoard gameBoard) {
        super();
        this.gameBoard = gameBoard;
    }


    @Override
    public void gameUpdate() {
        Collection<? extends IEntity> entities = getEntities();
        gameBoard.repaint(entities);
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(PositionComponent.class, ImageComponent.class);
    }

}
