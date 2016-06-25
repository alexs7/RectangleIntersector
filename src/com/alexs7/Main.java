package com.alexs7;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RectangleFileLoader loader = new RectangleFileLoader();
        ArrayList<Rectangle> rectangles = loader.read("/Users/alex/Projects/interviews/HawkEye/mySolutions/rectangle/rectangles.txt");

        if(!rectangles.get(0).intersect(rectangles.get(1))){
            System.out.println("They intersect");
        }
    }
}
