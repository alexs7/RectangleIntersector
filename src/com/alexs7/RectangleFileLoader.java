package com.alexs7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by alex on 20/06/2016.
 */
public class RectangleFileLoader {

    public ArrayList<Rectangle> read(String location) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        try {
            Stream<String> stream = Files.lines(Paths.get(location)); {
                stream.forEach(line -> rectangles.add(getRectangleFromString(line)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rectangles;
    }

    private Rectangle getRectangleFromString(String line) {
        Rectangle rectangle = null;
        Point p1;
        Point p2;
        Point p3;
        Point p4;
        for (int i = 0; i < line.length(); i++) {
            p1 = new Point(Double.parseDouble(String.valueOf(line.charAt(0))),Double.parseDouble(String.valueOf(line.charAt(2))));
            p2 = new Point(Double.parseDouble(String.valueOf(line.charAt(4))),Double.parseDouble(String.valueOf(line.charAt(6))));
            p3 = new Point(Double.parseDouble(String.valueOf(line.charAt(8))),Double.parseDouble(String.valueOf(line.charAt(10))));
            p4 = new Point(Double.parseDouble(String.valueOf(line.charAt(12))),Double.parseDouble(String.valueOf(line.charAt(14))));
            rectangle = new Rectangle(p1,p2,p3,p4);
        }
        return rectangle;
    }
}
