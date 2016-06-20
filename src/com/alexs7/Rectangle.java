package com.alexs7;

import java.awt.*;

/**
 * Created by alex on 20/06/2016.
 */
public class Rectangle {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Rectangle(Point p1, Point p2, Point p3, Point p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public boolean intersect(Rectangle rectangle){
        return false;
    }
}
