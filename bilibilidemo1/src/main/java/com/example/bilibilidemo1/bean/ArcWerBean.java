package com.example.bilibilidemo1.bean;

/**
 * Created by yida on 2018/6/1.
 */

public class ArcWerBean {

    float angle;//相对检测对象塔机角度
    int twlong;//臂长
    float twturnAngle;//转动角度
    int movewidth;//塔机移动距离
    int distance;//两个塔机相对距离
    String name;//塔机名字

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int getTwlong() {
        return twlong;
    }

    public void setTwlong(int twlong) {
        this.twlong = twlong;
    }

    public float getTwturnAngle() {
        return twturnAngle;
    }

    public void setTwturnAngle(float twturnAngle) {
        this.twturnAngle = twturnAngle;
    }

    public int getMovewidth() {
        return movewidth;
    }

    public void setMovewidth(int movewidth) {
        this.movewidth = movewidth;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
