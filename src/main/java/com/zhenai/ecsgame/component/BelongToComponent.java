package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;


/**
 * 标识belong to
 *
 * @author xl
 */
public class BelongToComponent extends AbstractComponent {

    public static final int PLAYER = 0;
    public static final int ENEMY = 1;

    private int belongTo;

    public BelongToComponent(IEntity entity) {
        super(entity);
    }

    public BelongToComponent(IEntity entity, int belongTo) {
        super(entity);
        this.belongTo = belongTo;
    }

    public int getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(int belongTo) {
        this.belongTo = belongTo;
    }

    public boolean isBelongToPlayer() {
        return belongTo == PLAYER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BelongToComponent that = (BelongToComponent) o;
        return belongTo == that.belongTo;
    }

    @Override
    public int hashCode() {
        return belongTo;
    }
}
