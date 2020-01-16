package com.zhenai.ecsgame.framwork.gameEngine.bean;

import java.util.Random;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/11:36
 * @Description:
 */
public class Vector2D {

    private static Random random = new Random();

    private double x;
    private double y;


    public Vector2D() {
        x = 1;
        y = 1;
        normalize();
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
        normalize();
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public Vector2D clone() {
        return new Vector2D(x, y);
    }

    //向量的方向翻转
    public Vector2D reverse() {
        x = -x;
        y = -y;
        return this;
    }

    //向量的标准化（方向不变，长度为1）
    public Vector2D normalize() {
        double length = getLength();
        x = x / length;
        y = y / length;
        return this;
    }

    public double getLength() {
        return Math.sqrt(getLengthSQ());
    }

    public double getLengthSQ() {
        return x * x + y * y;
    }

    public boolean isZero() {
        return x == 0 && y == 0;
    }

    public static Vector2D getRandomVector() {
        return new Vector2D(random.nextDouble(), random.nextDouble());
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
