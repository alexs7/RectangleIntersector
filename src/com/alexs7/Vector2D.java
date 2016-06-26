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

    /*  It returns the projection of the point on the normal passed as argument.
     *  The normal start from the origin. (0,0) up to (normal.x,normal.y)
     */
    public static Point getProjection(Point point, Vector2D normal) {
        double x = ((point.getX() * normal.getXComponent() + point.getY() * normal.getYComponent()) /
                (Math.pow(normal.getXComponent(),2) + Math.pow(normal.getYComponent(),2))) * normal.getXComponent();
        double y = ((point.getX() * normal.getXComponent() + point.getY() * normal.getYComponent()) /
                (Math.pow(normal.getXComponent(),2) + Math.pow(normal.getYComponent(),2))) * normal.getYComponent();

        return new Point(x,y);
    }

    public static boolean projectionsOverlap(ArrayList<Point> projectionsA, ArrayList<Point> projectionsB, Vector2D axis) {
        projectionsA = removeDuplicates(projectionsA);
        double maxA = getMax(projectionsA,axis);
        double minA = getMin(projectionsA,axis);

        projectionsB = removeDuplicates(projectionsB);
        double maxB = getMax(projectionsB,axis);
        double minB = getMin(projectionsB,axis);

        if(minA > maxB || minB > maxA){
            return false;
        }else{
            return true;
        }
    }

    private static double getMin(ArrayList<Point> projections, Vector2D axis) {
        double min = Double.MAX_VALUE;
        double value;

        for(Point projection : projections){
            value = (projection.getX() * axis.getXComponent()) / Math.sqrt(Math.pow(axis.getXComponent(),2) + Math.pow(axis.getYComponent(),2)) +
                    (projection.getY() * axis.getYComponent()) / Math.sqrt(Math.pow(axis.getXComponent(),2) + Math.pow(axis.getYComponent(),2));

            if(min > value){
                min = value;
            }
        }

        return min;
    }

    private static double getMax(ArrayList<Point> projections, Vector2D axis) {
        double max = -Double.MAX_VALUE;
        double value;

        for(Point projection : projections){
            value = (projection.getX() * axis.getXComponent()) / Math.sqrt(Math.pow(axis.getXComponent(),2) + Math.pow(axis.getYComponent(),2)) +
                    (projection.getY() * axis.getYComponent()) / Math.sqrt(Math.pow(axis.getXComponent(),2) + Math.pow(axis.getYComponent(),2));

            if(max < value){
                max = value;
            }
        }

        return max;
    }

    public double getXComponent() {
        return xComponent;
    }

    public double getYComponent() {
        return yComponent;
    }

    private static ArrayList<Point> removeDuplicates(ArrayList<Point> projections) {
        ArrayList<Point> newProjections = new ArrayList<>();

        for (Point point : projections){
            boolean duplicated = false;
            for (Point newPoint : newProjections){
                if(newPoint.equals(point)){
                    duplicated = true;
                }
            }
            if(!duplicated){
                newProjections.add(point);
            }
        }

        return newProjections;
    }
}
