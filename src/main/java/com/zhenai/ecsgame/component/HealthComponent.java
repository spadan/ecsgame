package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;

import java.awt.image.BufferedImage;
import java.util.Map;


/**
 * 生命组件
 *
 * @author xl
 */
public class HealthComponent extends AbstractComponent {

    /**
     * 生命
     */
    private int hp;

    private Map<Integer, BufferedImage> outlineMap;

    public HealthComponent(IEntity entity) {
        super(entity);
    }

    public HealthComponent(IEntity entity, int hp) {
        super(entity);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
