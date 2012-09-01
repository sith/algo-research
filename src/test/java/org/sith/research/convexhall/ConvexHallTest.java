package org.sith.research.convexhall;

import junit.framework.TestCase;

import java.util.Collection;

public class ConvexHallTest extends TestCase {

    public void test() throws Exception {

        ConvexHall convexHull = new ConvexHall();

        convexHull.addPoint("A", 6, 1);
        convexHull.addPoint("B", 3, 2);
        convexHull.addPoint("C", 5, 9);
        convexHull.addPoint("D", 7, 5);
        convexHull.addPoint("E", 9, 6);
        convexHull.addPoint("F", 2, 0);
        convexHull.addPoint("G", 8, 4);
        convexHull.addPoint("H", 1, 7);
        convexHull.addPoint("I", 0, 8);
        convexHull.addPoint("J", 4, 3);


        Collection<Point2D> calculate = convexHull.calculate();


        for (Point2D point2D : convexHull.getRemoved()) {
            System.out.println(point2D);
        }

    }

    public void test3() throws Exception {

        ConvexHall convexHull = new ConvexHall();

        convexHull.addPoint("A", 5, 5);
        convexHull.addPoint("B", 3, 4);
        convexHull.addPoint("C", 8, 0);
        convexHull.addPoint("D", 6, 3);
        convexHull.addPoint("E", 9, 6);
        convexHull.addPoint("F", 7, 9);
        convexHull.addPoint("G", 1, 2);
        convexHull.addPoint("H", 4, 8);
        convexHull.addPoint("I", 0, 7);
        convexHull.addPoint("J", 2, 1);


        Collection<Point2D> calculate = convexHull.calculate();


        for (Point2D point2D : convexHull.getRemoved()) {
            System.out.println(point2D);
        }

    }


    public void test2() throws Exception {

        ConvexHall convexHull = new ConvexHall();

        convexHull.addPoint("A", 2, 0);
        convexHull.addPoint("B", 3, 1);
        convexHull.addPoint("C", 4, 2);
        convexHull.addPoint("D", 5, 3);
        convexHull.addPoint("E", 3, 3);
        convexHull.addPoint("F", 2, 3);
        convexHull.addPoint("G", 2, 5);
        convexHull.addPoint("H", 1, 4);


        Collection<Point2D> calculate = convexHull.calculate();


        for (Point2D point2D : convexHull.getRemoved()) {
            System.out.println(point2D);
        }

    }

}
