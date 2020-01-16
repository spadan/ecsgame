package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;


/**
 * 伤害组件
 *
 * @author xl
 */
public class DamageComponent extends AbstractComponent {

    /**
     * 伤害
     */
    private int damage;


    public DamageComponent(IEntity entity) {
        super(entity);
    }

    public DamageComponent(IEntity entity, int damage) {
        super(entity);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
