package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;


/**
 * 自动开火组件
 *
 * @author xl
 */
public class AutoFireComponent extends AbstractComponent {

    /**
     * 每过frames帧执行一次开火
     */
    private int frames;

    /**
     * 每次开火发射的子弹数量
     */
    private int bullets;

    /**
     * 开火方向
     */
    private Direction direction;

    public AutoFireComponent(IEntity entity) {
        super(entity);
    }

    public AutoFireComponent(IEntity entity, int frames, int bullets, Direction direction) {
        super(entity);
        this.frames = frames;
        this.bullets = bullets;
        this.direction = direction;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
