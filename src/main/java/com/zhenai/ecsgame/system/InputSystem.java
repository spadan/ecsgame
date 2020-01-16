package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.PlayerComponent;
import com.zhenai.ecsgame.component.PositionComponent;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.GameBoard;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;
import java.util.Collection;

/**
 * 输入系统，控制玩家的位置
 *
 * @author haitong.zhang
 * @date 2019/12/31/14:37
 */
@Component
@DependsOn(value = "entityManager")
public class InputSystem extends AbstractSystemImpl {
    private static final Logger logger = LoggerFactory.getLogger(InputSystem.class);

    private Integer x;
    private Integer y;

    @Autowired
    public InputSystem(GameBoard gameBoard) {
        super();
        gameBoard.addMouseMotionListener(new MyMouseListener());
    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return Arrays.asList(PlayerComponent.class, PositionComponent.class);
    }

    @Override
    public void gameUpdate() {
        if (x != null && y != null) {
            for (IEntity entity : getEntities()) {
                PositionComponent positionComponent = entity.getComponent(PositionComponent.class);
                positionComponent.setPosition(new Position(x, y));
            }
            x = y = null;
        }
    }


    private class MyMouseListener extends MouseMotionAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            logger.debug("mouse drag event,x {},y {}", x, y);
        }
    }

}
