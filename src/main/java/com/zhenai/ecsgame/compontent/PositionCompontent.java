package com.zhenai.ecsgame.compontent;

import com.zhenai.ecsgame.framwork.entity.IEntity;
import com.zhenai.ecsgame.framwork.component.AbstractCompontent;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/30/15:57
 * @Description:游戏对象位置模块
 */
public class PositionCompontent extends AbstractCompontent {

    private Position position;


    public PositionCompontent(IEntity compontent) {
        super(compontent);
        position = new Position();
    }

    public PositionCompontent(IEntity entity, double x, double y) {
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
