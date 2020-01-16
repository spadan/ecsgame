package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;


/**
 * 加速度
 *
 * @author xl
 */
public class ToCleanComponent extends AbstractComponent {

    /**
     * 每过frames帧执行一次加速
     */
    private int frames;


    public ToCleanComponent(IEntity entity) {
        super(entity);
    }

    public ToCleanComponent(IEntity entity, int frames) {
        super(entity);
        this.frames = frames;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }
}
