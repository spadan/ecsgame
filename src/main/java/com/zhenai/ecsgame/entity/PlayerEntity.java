package com.zhenai.ecsgame.entity;

import com.zhenai.ecsgame.component.*;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.entity.AbstractEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.BelongTo;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:58
 * @Description:机器人
 */
public class PlayerEntity extends AbstractEntity {

    private static String playerImageName = "player";

    public PlayerEntity() {
        super();
        PlayerComponent player = new PlayerComponent(this);
        BelongToComponent belongTo = new BelongToComponent(this, BelongTo.PLAYER);
        HealthComponent health = new HealthComponent(this, 3);
        DamageComponent damage = new DamageComponent(this, Integer.MAX_VALUE);
        ImageComponent outline = new ImageComponent(this, Constant.PLAYER_WIDTH, Constant.PLAYER_HEIGHT,
                2, playerImageName);
        PositionComponent bornPosition = new PositionComponent(this
                , (Constant.BOARD_WIDTH - Constant.PLAYER_WIDTH) >> 2
                , Constant.BOARD_HEIGHT - Constant.PLAYER_HEIGHT);
        AutoFireComponent autoFire = new AutoFireComponent(this, 5, 1, Direction.UP);
        OutboundOkComponent outboundOk = new OutboundOkComponent(this);
        addComponent(player)
                .addComponent(belongTo)
                .addComponent(health)
                .addComponent(damage)
                .addComponent(outline)
                .addComponent(bornPosition)
                .addComponent(autoFire)
                .addComponent(outboundOk);
    }

}
