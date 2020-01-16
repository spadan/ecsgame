package com.zhenai.ecsgame.framwork.gameEngine.bean;


/**
 * 五个方位
 *
 * @author xl
 */
public enum Direction {
    /**
     * 原地不动
     */
    ZERO(0, 0),
    /**
     * 上移
     */
    UP(0, -1),
    /**
     * 下移
     */
    DOWN(0, 1),
    /**
     * 左移
     */
    LEFT(-1, 0),
    /**
     * 右移
     */
    RIGHT(1, 0),
    ;
    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
