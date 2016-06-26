package com.alexs7;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String fileLocationArg;

        if(args.length == 1 ){
            fileLocationArg = args[0];
        }else{
            fileLocationArg = "rectangles.txt";
        }

        RectangleFileLoader loader = new RectangleFileLoader();
        ArrayList<Rectangle> rectangles = loader.read(fileLocationArg);

        //Looping through the rectangles and printing out if they intersect or not
        for (int i = 0; i < rectangles.size(); i++) {
            for (int j = i+1; j < rectangles.size() ; j++) {

                if(rectangles.get(i).intersect(rectangles.get(j))){
                    System.out.println("Rectangle "+i+" and Rectangle "+j+" intersect");
                }else{
                    System.out.println("Rectangle "+i+" and Rectangle "+j+" do not intersect");
                }

            }
        }
    }
}
