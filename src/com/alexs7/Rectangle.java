package com.alexs7;

import java.awt.*;
import java.util.ArrayList;

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
        boolean intersect = true;

        Vector2D vector01Rec01 = new Vector2D(p1,p2);
        Vector2D vector02Rec01 = new Vector2D(p3,p2);

        Vector2D normalToVector01Rec01 = vector01Rec01.getNormals().get(0);
        Vector2D normalToVector02Rec01 = vector02Rec01.getNormals().get(0);

        Vector2D vector01Rec02 = new Vector2D(rectangle.p1,rectangle.p2);
        Vector2D vector02Rec02 = new Vector2D(rectangle.p3,rectangle.p2);

        Vector2D normalToVector01Rec02 = vector01Rec02.getNormals().get(0);
        Vector2D normalToVector02Rec02 = vector02Rec02.getNormals().get(0);

        //we only need 2 normals for each rectangle that is 4 vectors from the origin.
        ArrayList<Vector2D> normals = new ArrayList<>();
        normals.add(normalToVector01Rec01);
        normals.add(normalToVector02Rec01);
        normals.add(normalToVector01Rec02);
        normals.add(normalToVector02Rec02);

        ArrayList<Point> projectionsRec01 = new ArrayList<>();
        ArrayList<Point> projectionsRec02 = new ArrayList<>();

        mainloop:
        for (Vector2D normal : normals){

            for (Point point : getAllPoints()){
                projectionsRec01.add(Vector2D.getProjection(point,normal));
            }

            for (Point point : rectangle.getAllPoints()){
                projectionsRec02.add(Vector2D.getProjection(point,normal));
            }

            boolean overlap = Vector2D.projectionsOverlap(projectionsRec01,projectionsRec02,normal);
            if(!overlap){
                intersect = false;
                break mainloop;
            }
            projectionsRec01.clear();
            projectionsRec02.clear();
        }

        return intersect;
    }

    public ArrayList<Point> getAllPoints(){
        ArrayList<Point> points = new ArrayList<>();

        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        return points;
    }
}
