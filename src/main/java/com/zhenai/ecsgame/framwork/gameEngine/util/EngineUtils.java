package com.zhenai.ecsgame.framwork.gameEngine.util;

import com.zhenai.ecsgame.framwork.constant.Constant;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Direction;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Size;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/13:43
 * @Description:
 */
public class EngineUtils {

    /**
     * 计算移动终点
     *
     * @param direction
     * @param startPosition
     * @param speed
     * @return
     */
    public static Position getEndPosition(Direction direction, Position startPosition, int speed) {
        Position endPosition = Position.cloneNew(startPosition);
        switch (direction) {
            case UP:
            case DOWN:
                endPosition.setY(startPosition.getY() + speed * direction.getY());
                break;
            case LEFT:
            case RIGHT:
                endPosition.setX(startPosition.getX() + speed * direction.getX());
                break;
            case ZERO:
            default:
                break;
        }
        return endPosition;
    }

    /**
     * 组件是否出界
     *
     * @param position 组件所在的位置
     * @param size     组件的尺寸
     * @return
     */
    public static boolean isOutbound(Position position, Size size) {
        double x = position.getX();
        double y = position.getY();
        int width = size.getWidth();
        int height = size.getHeight();
        return x < 0 || y < 0 || x > Constant.BOARD_WIDTH - width || y > Constant.BOARD_HEIGHT - height;
    }

    /**
     * 组件之间是否碰撞
     *
     * @param position1 组件1的位置
     * @param size1     组件1的尺寸
     * @param position2 组件2的位置
     * @param size2     组件2的尺寸
     * @return
     */
    public static boolean isCollisionWithRect(Position position1, Size size1, Position position2, Size size2) {
        int x1 = position1.getX();
        int y1 = position1.getY();
        int w1 = size1.getWidth();
        int h1 = size1.getHeight();
        int x2 = position2.getX();
        int y2 = position2.getY();
        int w2 = size2.getWidth();
        int h2 = size2.getHeight();
        if (x1 >= x2 && x1 >= x2 + w2) {
            return false;
        } else if (x1 <= x2 && x1 + w1 <= x2) {
            return false;
        } else if (y1 >= y2 && y1 >= y2 + h2) {
            return false;
        } else {
            return y1 > y2 || y1 + h1 > y2;
        }
    }
}
