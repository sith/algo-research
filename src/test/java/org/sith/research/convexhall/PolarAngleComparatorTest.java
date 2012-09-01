package org.sith.research.convexhall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolarAngleComparatorTest {


    @Test
    public void test() throws Exception {


        PolarAngleComparator comparator = new PolarAngleComparator(new Point2D("A", 0, 0));

        List<Point2D> points = new ArrayList<>();
        points.add(new Point2D("A", 1, 1));
        points.add(new Point2D("A", 1, 5));
        points.add(new Point2D("A", 3, 2));


        Collections.sort(points, comparator);
        for (Point2D point : points) {
            System.out.println(point);
        }

    }
}
