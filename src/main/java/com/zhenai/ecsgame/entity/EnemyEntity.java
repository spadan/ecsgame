package com.zhenai.ecsgame.entity;

import com.zhenai.ecsgame.component.*;
import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.entity.AbstractEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;
import org.apache.commons.lang3.RandomUtils;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:58
 * @Description:机器人
 */
public class EnemyEntity extends AbstractEntity {

    private static String enemyImageName = "enemy";


    public EnemyEntity() {
        super();
        BelongToComponent belongTo = new BelongToComponent(this, BelongToComponent.ENEMY);
        HealthComponent health = new HealthComponent(this, 1);
        DamageComponent damage = new DamageComponent(this, 1);
        ShapeComponent shape = new ShapeComponent(this, Constant.ENEMY_WIDTH, Constant.ENEMY_HEIGHT, enemyImageName);
        int x = RandomUtils.nextInt(0, Constant.BOARD_WIDTH - Constant.PLAYER_WIDTH);
        PositionComponent startPosition = new PositionComponent(this, x, 0);
        int speed = RandomUtils.nextInt(1, 8);
        MoveComponent move = new MoveComponent(this, Integer.MAX_VALUE, Direction.DOWN, speed);
        this.addComponent(belongTo)
            .addComponent(health)
            .addComponent(damage)
            .addComponent(shape)
            .addComponent(startPosition)
            .addComponent(move);
    }

    public void setHealth(int hp) {
        getComponent(HealthComponent.class).setHp(hp);
    }

    public void setImage(String image) {
        getComponent(ShapeComponent.class).setImageName(image);
    }

    public void setSpeed(int speed) {
        getComponent(MoveComponent.class).setMoveSpeed(speed);
    }

    public void setSize(int w, int h) {
        getComponent(ShapeComponent.class).setSize(new Size(w, h));
    }


}
