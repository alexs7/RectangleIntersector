# Separating Axis Theorem (SAT) in Java

This small program will take 2 rectangles of any orientation and using SAT it will return true if they intersect or not.

## Separating Axis Theorem (SAT)
The separating axis theorem states that for a pair of convex polygons (rectangles in our case) that are not in a state of collision there exists an axis perpendicular to an edge of one of the polygons that has no overlap between the projected vertices of the two polygons. 
Essentially, what this means is that if we project the vertices of the two polygons that we are testing onto each axis that is perpendicular to the edges (normals) of each polygon and we detect an overlap on each polygon there is a collision, if even one axis shows no overlap then a collision is impossible.

## How to use

This was developed on Java 8.
In order to run this you would need 2 files, ```rectangle.jar``` and a files to read the rectangles from, ```rectangles.txt```.
Both files are found in this repository.

Put both files in the same directory. Running ```java -jar rectangle.jar rectangles.txt``` will compare all rectangles in the give file,
and print out if the intersect or not.

I have already included 4 sample rectangles and below you can see a visualization of Rectangle 3 and 4 in the file (coordinates not accurate), ```rectangles.txt```:

![alt tag](https://s31.postimg.org/5jca44097/Screen_Shot_2016_06_26_at_21_17_24.png)
