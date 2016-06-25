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
            System.out.println("File, rectangles.txt not found!");
            e.printStackTrace();
        }

        return rectangles;
    }

    private Rectangle getRectangleFromString(String line) {
        String[] lineArray = line.split(" ");
        Point p1 = new Point(Double.parseDouble(lineArray[0]), Double.parseDouble(lineArray[1]));
        Point p2 = new Point(Double.parseDouble(lineArray[2]), Double.parseDouble(lineArray[3]));
        Point p3 = new Point(Double.parseDouble(lineArray[4]), Double.parseDouble(lineArray[5]));
        Point p4 = new Point(Double.parseDouble(lineArray[6]), Double.parseDouble(lineArray[7]));
        Rectangle rectangle = new Rectangle(p1,p2,p3,p4);
        return rectangle;
    }
}
