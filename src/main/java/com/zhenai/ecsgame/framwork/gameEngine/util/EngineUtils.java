package com.zhenai.ecsgame.framwork.gameEngine.util;

import com.zhenai.ecsgame.compontent.PositionCompontent;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Position;
import com.zhenai.ecsgame.framwork.gameEngine.bean.Vector2D;
import sun.security.util.Length;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/13:43
 * @Description:
 */
public class EngineUtils {

    /**
     * 计算移动终点
     * @param v
     * @param startPostion
     * @param length
     * @return
     */
    public static Position getResultPostion(Vector2D v, Position startPostion, double length) {
        Position resultPosition = Position.cloneNew(startPostion);

        if (v.isZero()) {
            return resultPosition;
        } else {
            if (v.getX() == 0) {
                resultPosition.setY(startPostion.getY() + length);
                return resultPosition;
            }

            if (v.getY() == 0) {
                resultPosition.setX(startPostion.getX() + length);
                return resultPosition;
            }
            double temYX = (v.getY() / v.getX());
            double length_ll = (length * length);
            double moveX = Math.sqrt(length_ll / ((temYX * temYX) + 1));
            double moveY = Math.sqrt(length_ll - moveX * moveX);
            resultPosition.setX(startPostion.getX() + moveX);
            resultPosition.setY(startPostion.getY() + moveY);
            return resultPosition;
        }
    }

    public static void main(String[] args) {
        Vector2D v = new Vector2D();
        Position position = new Position();
        System.out.println(getResultPostion(v, position, Math.sqrt(2)));
    }
}
