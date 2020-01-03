package com.zhenai.ecsgame.framwork.gameEngine.bean;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/13:51
 * @Description:
 */
public class Position {

    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
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
