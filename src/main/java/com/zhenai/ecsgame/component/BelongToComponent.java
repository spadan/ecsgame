package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.BelongTo;


/**
 * 标识belong to
 *
 * @author xl
 */
public class BelongToComponent extends AbstractComponent {

    private BelongTo belongTo;

    public BelongToComponent(IEntity entity) {
        super(entity);
    }

    public BelongToComponent(IEntity entity, BelongTo belongTo) {
        super(entity);
        this.belongTo = belongTo;
    }

    public BelongTo getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(BelongTo belongTo) {
        this.belongTo = belongTo;
    }
}
