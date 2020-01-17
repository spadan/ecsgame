package com.zhenai.ecsgame.entity;

import com.zhenai.ecsgame.component.*;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.entity.AbstractEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.BelongTo;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;
import org.apache.commons.lang3.RandomUtils;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:58
 * @Description:机器人
 */
public class PlaneEntity extends AbstractEntity {

    private static String enemyImageName = "enemy";


    public PlaneEntity() {
        super();
        PlaneComponent plane = new PlaneComponent(this);
        BelongToComponent belongTo = new BelongToComponent(this, BelongTo.ENEMY);
        HealthComponent health = new HealthComponent(this, 1);
        DamageComponent damage = new DamageComponent(this, 1);
        ImageComponent outline = new ImageComponent(this, Constant.ENEMY_WIDTH, Constant.ENEMY_HEIGHT, 2,
                enemyImageName);
        int x = RandomUtils.nextInt(0, Constant.BOARD_WIDTH - Constant.PLAYER_WIDTH);
        PositionComponent bornPosition = new PositionComponent(this, x, 0);
        int speed = RandomUtils.nextInt(1, 8);
        MoveComponent move = new MoveComponent(this, Integer.MAX_VALUE, Direction.DOWN, speed);
        this.addComponent(plane)
            .addComponent(belongTo)
            .addComponent(health)
            .addComponent(damage)
            .addComponent(outline)
            .addComponent(bornPosition)
            .addComponent(move);
    }

}
