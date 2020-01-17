package com.zhenai.ecsgame.system;

import com.zhenai.ecsgame.component.*;
import com.zhenai.ecsgame.entity.CommonEntity;
import com.zhenai.ecsgame.entity.PlayerEntity;
import com.zhenai.ecsgame.framwork.component.IComponent;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;
import com.zhenai.ecsgame.framwork.system.AbstractSystemImpl;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 玩家释放系统
 *
 * @author haitong.zhang
 * @date 2019/12/31/14:37
 */
@Component
@DependsOn(value = "entityManager")
public class PlayerReleaseSystem extends AbstractSystemImpl {

    private boolean isInit = false;

    @Override
    public void gameUpdate() {
        if (!isInit) {
            addPlayer();
            addBg();
            isInit = true;
        }
    }


    /**
     * 添加游戏用户
     */
    private void addPlayer() {
        new PlayerEntity();
    }

    private void addBg() {
        int w = Constant.BOARD_WIDTH;
        int h = Constant.BOARD_HEIGHT;

        CommonEntity bg1 = new CommonEntity();
        bg1.addComponent(new BgComponent(bg1));
        bg1.addComponent(new PositionComponent(bg1, 0, 0));
        bg1.addComponent(new ImageComponent(bg1, w, h, 1, "bg"));
        bg1.addComponent(new MoveComponent(bg1, Integer.MAX_VALUE, Direction.DOWN, 1));
        bg1.addComponent(new OutboundOkComponent(bg1));
        bg1.addComponent(new RenewComponent(bg1, 0, -h));

        CommonEntity bg2 = new CommonEntity();
        bg2.addComponent(new BgComponent(bg2));
        bg2.addComponent(new PositionComponent(bg2, 0, -h));
        bg2.addComponent(new ImageComponent(bg2, w, h, 1, "bg"));
        bg2.addComponent(new MoveComponent(bg2, Integer.MAX_VALUE, Direction.DOWN, 1));
        bg2.addComponent(new OutboundOkComponent(bg2));
        bg2.addComponent(new RenewComponent(bg2, 0, -h));

    }

    @Override
    public Collection<Class<? extends IComponent>> interestComponent() {
        return null;
    }
}
