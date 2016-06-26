package com.alexs7;

/**
 * Created by alex on 20/06/2016.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean equals(Point point){
        return (x == point.getX()) && (y == point.getY());
    }
}
