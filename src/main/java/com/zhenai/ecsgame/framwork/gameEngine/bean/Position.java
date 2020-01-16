package com.zhenai.ecsgame.framwork.gameEngine.bean;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/13:51
 * @Description:
 */
public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Position cloneNew(Position p){
        return new Position(p.getX(),p.getY());
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + String.format("%.2f", x) +
                ", y=" +  String.format("%.2f", y) +
                '}';
    }
}
