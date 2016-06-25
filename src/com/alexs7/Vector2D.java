package com.alexs7;

import java.util.ArrayList;

/**
 * Created by alex on 25/06/2016.
 */
public class Vector2D {

    private double xComponent;
    private double yComponent;

    public Vector2D(Point p1, Point p2) {
        this.xComponent = p2.getX() - p1.getX();
        this.yComponent = p2.getY() - p1.getY();
    }

    public Vector2D(double xComponent, double yComponent) {
        this.xComponent = xComponent;
        this.yComponent = yComponent;
    }

    public ArrayList<Vector2D> getNormals(){

        ArrayList<Vector2D> normalVectors = new ArrayList<>();
        normalVectors.add(new Vector2D(-yComponent,xComponent));
        normalVectors.add(new Vector2D(yComponent,-xComponent));

        return normalVectors;
    }

    public Point getProjectionOfPointOnNormal(Point point, Vector2D normal){

        return null;
    }

    public static Point getProjection(Point point, Vector2D normal) {
        double x = ((point.getX() * normal.getXComponent() + point.getY() * normal.getYComponent()) /
                (Math.pow(normal.getXComponent(),2) + Math.pow(normal.getYComponent(),2))) * normal.getXComponent();
        double y = ((point.getX() * normal.getXComponent() + point.getY() * normal.getYComponent()) /
                (Math.pow(normal.getXComponent(),2) + Math.pow(normal.getYComponent(),2))) * normal.getYComponent();

        return new Point(x,y);
    }

    public double getXComponent() {
        return xComponent;
    }

    public double getYComponent() {
        return yComponent;
    }

    public static boolean projectionsOverlap(ArrayList<Point> projections1, ArrayList<Point> projections2) {
        return false;
    }
}
