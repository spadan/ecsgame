package com.zhenai.ecsgame.component;

import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.component.AbstractComponent;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/15:57
 * @Description:游戏对象位置模块
 */
public class PositionComponent extends AbstractComponent {

    private Position position;


    public PositionComponent(IEntity compontent) {
        super(compontent);
        position = new Position();
    }

    public PositionComponent(IEntity entity, double x, double y) {
        super(entity);
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }


}
