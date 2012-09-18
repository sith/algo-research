package org.sith.research.intersection;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class IntersectionTest {
    @Test
    public void testIntersection() throws Exception {


        Intersection intersection = new Intersection();

        intersection.addLine(createLine(2, 2, 6, 2, ""));
        intersection.addLine(createLine(3, 2, 3, 4, ""));
        intersection.addLine(createLine(4, 5, 6, 5, ""));
        intersection.addLine(createLine(5, 6, 8, 6, ""));
        intersection.addLine(createLine(5, 4, 5, 8, ""));


        intersection.intersection();

        assertThat(intersection.intersectionCount, is(3));


    }

    @Test
    public void testIntersection1() throws Exception {


        Intersection intersection = new Intersection();

        /*A ( 9, 15)  ->  (19, 15)  [ horizontal ]
B ( 2, 10)  ->  (14, 10)  [ horizontal ]
C (10,  1)  ->  (10, 15)  [ vertical   ]
D (15,  2)  ->  (15, 15)  [ vertical   ]
E ( 7, 13)  ->  (18, 13)  [ horizontal ]
F (13,  3)  ->  (13, 12)  [ vertical   ]
G (11,  0)  ->  (16,  0)  [ horizontal ]
H ( 3,  9)  ->  ( 8,  9)  [ horizontal ]*/


        intersection.addLine(createLine(9, 15, 19, 15, "A"));
        intersection.addLine(createLine(2, 10, 14, 10, "B"));
        intersection.addLine(createLine(10, 1, 10, 15, "C"));
        intersection.addLine(createLine(15, 2, 15, 15, "D"));
        intersection.addLine(createLine(7, 13, 18, 13, "E"));
        intersection.addLine(createLine(13, 3, 13, 12, "F"));
        intersection.addLine(createLine(11, 0, 16, 0, "G"));
        intersection.addLine(createLine(3, 9, 8, 9, "H"));


        intersection.intersection();

        assertThat(intersection.intersectionCount, is(7));


    }

    private Intersection.Line createLine(int startX, int startY, int endX, int endY, String name) {
        Intersection.Line line = new Intersection.Line(name);
        line.setStart(startX, startY);
        line.setEnd(endX, endY);
        return line;
    }
}
