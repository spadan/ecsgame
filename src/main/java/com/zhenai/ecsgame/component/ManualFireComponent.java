package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;

/**
 * 手动开火组件
 *
 * @author xl
 */
@Deprecated
public class ManualFireComponent extends AbstractComponent {

    /**
     * 发射的子弹数量
     */
    private int bullets;

    /**
     * 子弹方向
     */
    private Direction direction;


    public ManualFireComponent(IEntity entity) {
        super(entity);
    }

    public ManualFireComponent(IEntity entity, int bullets) {
        super(entity);
        this.bullets = bullets;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }
}
