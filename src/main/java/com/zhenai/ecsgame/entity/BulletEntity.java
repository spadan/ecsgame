package com.zhenai.ecsgame.entity;

import com.zhenai.ecsgame.component.*;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.entity.AbstractEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:58
 * @Description:机器人
 */
public class BulletEntity extends AbstractEntity {

    private static String bulletImageName = "bullet";

    public BulletEntity() {
        super();
        BulletComponent bullet = new BulletComponent(this);
        ImageComponent shape = new ImageComponent(this, Constant.BULLET_WIDTH, Constant.BULLET_HEIGHT,
                2, bulletImageName);
        addComponent(shape).addComponent(bullet);
    }

    public BulletEntity(int startX, int startY) {
        super();
        BulletComponent bullet = new BulletComponent(this);
        HealthComponent health = new HealthComponent(this, 1);
        DamageComponent damage = new DamageComponent(this, 1);
        ImageComponent outline = new ImageComponent(this, Constant.BULLET_WIDTH, Constant.BULLET_HEIGHT,
                2, bulletImageName);
        PositionComponent bornPosition = new PositionComponent(this, startX, startY);
        MoveComponent move = new MoveComponent(this, Integer.MAX_VALUE,
                Direction.UP, 3);
        AccComponent acc = new AccComponent(this, Constant.FRAME_SPEED, 2);
        addComponent(bullet)
                .addComponent(outline)
                .addComponent(health)
                .addComponent(damage)
                .addComponent(bornPosition)
                .addComponent(move)
                .addComponent(acc);
    }

}
