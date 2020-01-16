package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;


/**
 * 加速度
 *
 * @author xl
 */
public class AccComponent extends AbstractComponent {

    /**
     * 每过frames帧执行一次加速
     */
    private int frames;
    /**
     * 每次加速的增量值
     */
    private int acc;

    public AccComponent(IEntity entity) {
        super(entity);
    }

    public AccComponent(IEntity entity, int frames, int acc) {
        super(entity);
        this.frames = frames;
        this.acc = acc;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }
}
