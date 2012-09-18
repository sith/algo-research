package org.sith.research.intersection;


import java.util.*;

public class Intersection {


    Map<Point, Line> horizontals = new HashMap<Point, Line>();
    Map<Point, Line> verticals = new HashMap<Point, Line>();
    List<Point> points = new ArrayList<Point>();
    List<Line> ranges = new ArrayList<Line>();
    int intersectionCount = 0;

    public void addLine(Line line) {

        points.add(line.start);
        if (line.isVertical()) {
            verticals.put(line.start, line);
        } else {
            points.add(line.end);
            horizontals.put(line.start, line);
        }
    }


    public void intersection() {

        Collections.sort(points);


        for (Point point : points) {

            Line verticalLine = verticals.get(point);
            if (verticalLine != null && verticalLine.isVertical()) {
                findRange(verticalLine);

            } else {
                if (point.endPoint) {
                    closeLine(point);
                } else {
                    ranges.add(horizontals.get(point));
                }


            }


        }
    }

    private void findRange(Line verticalLine) {

        int from = verticalLine.start.y;
        int to = verticalLine.end.y;


        for (Point point : verticals.keySet()) {
            if (point.y >= from && point.y <= to) {
                intersectionCount++;
            }
        }

        System.out.println(verticalLine.name);
        for (Line range : ranges) {
            System.out.println(range);
        }
        System.out.println();

    }

    private void closeLine(Point point) {
        for (Iterator<Line> iterator = ranges.iterator(); iterator.hasNext(); ) {
            Line range = iterator.next();
            if (range.start.y == point.y) {
                iterator.remove();
                return;
            }
        }
    }


    static class Line {
        Point start, end;
        private String name;

        public Line(String name) {


            this.name = name;
        }

        boolean isVertical() {
            return start.x == end.x;
        }

        void setStart(int x, int y) {
            start = new Point(x, y);
        }

        void setEnd(int x, int y) {
            end = new Point(x, y);
            end.endPoint = true;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "start=" + start +
                    ", end=" + end +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class Point implements Comparable<Point> {
        int x, y;
        boolean endPoint = false;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int delta = x - o.x;

            if (delta == 0) {
                if (endPoint) {
                    return +1;
                }
                if (o.endPoint) {
                    return -1;
                }
            }
            return delta;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", endPoint=" + endPoint +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (endPoint != point.endPoint) return false;
            if (x != point.x) return false;
            if (y != point.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + (endPoint ? 1 : 0);
            return result;
        }
    }

}
