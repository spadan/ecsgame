package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;

/**
 * @Auther: haitong.zhang
 * @Date: 2020/01/03/10:51
 * @Description:身份信息模块
 */
public class RenewComponent extends AbstractComponent {

    private Position position;

    public RenewComponent(IEntity entity, int x, int y) {
        super(entity);
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
