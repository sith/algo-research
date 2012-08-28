package org.sith.research.transport;


import java.util.*;

public class PotentialMethod {

    int[][] matrix;

    int currentLine = 0;

    private List<Integer> providers;
    private List<Integer> needs;

    private TreeSet<Element> elements = new TreeSet<Element>();

    private Set<Integer> usedRows = new HashSet<Integer>();
    private Set<Integer> usedColumns = new HashSet<Integer>();

    private List<Element> results = new ArrayList<Element>();

    public void addProviders(int... providers) {

        this.providers = new ArrayList<Integer>();
        for (int provider : providers) {
            this.providers.add(provider);
        }
    }

    public void addNeedAndPrices(int... needs) {
        this.needs = new ArrayList<Integer>();
        for (int need : needs) {
            this.needs.add(need);
        }
    }

    public void buildMatrix() {
        int sumProviders = sum(providers);
        int sumNeeds = sum(needs);

        if (sumProviders > sumNeeds) {
            matrix = new int[providers.size()][needs.size() + 1];
            needs.add(sumProviders - sumNeeds);
            for (int i = 0; i < providers.size(); i++) {
                elements.add(new Element(new Coordinate(i, needs.size() - 1), 0));
            }
        } else {
            matrix = new int[providers.size()][needs.size()];
        }

    }


    public void addPrices(int... prices) {

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            matrix[currentLine][i] = price;
            elements.add(new Element(new Coordinate(currentLine, i), price));
        }
        currentLine++;
    }

    private int sum(List<Integer> array) {
        int sum = 0;

        for (int integer : array) {
            sum += integer;
        }
        return sum;
    }

    public void printElements() {

        for (Element element : elements) {
            System.out.println(element);
        }


    }

    public void printMatrix() {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print("   " + anInt + "   ");
            }
            System.out.println();
        }
    }


    public List<Element> findInitialSolution() {

        for (Element element : elements) {
            Coordinate coordinate = element.coordinate;
            Integer provided = providers.get(coordinate.i);
            Integer needed = needs.get(coordinate.j);

            if (checkCoordinate(coordinate)) {
                continue;
            }

            if (provided >= needed) {
                usedColumns.add(coordinate.j);
                providers.set(coordinate.i, provided - needed);
                needs.set(coordinate.j, 0);
                results.add(new Element(coordinate, needed));
            } else {
                usedRows.add(coordinate.i);
                needs.set(coordinate.j, needed - provided);
                providers.set(coordinate.i, 0);
                results.add(new Element(coordinate, provided));
            }


        }
        return results;
    }


    private boolean checkCoordinate(Coordinate coordinate) {
        return usedRows.contains(coordinate.i) || usedColumns.contains(coordinate.j);
    }

    class Element implements Comparable<Element> {
        Coordinate coordinate;
        int value;

        Element(Coordinate coordinate, int value) {
            this.coordinate = coordinate;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "coordinate=" + coordinate +
                    ", value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Element o) {
            if (value == 0) {
                return Integer.MAX_VALUE;
            }
            if (o.value == 0) {
                return Integer.MIN_VALUE;
            }
            int compare = value - o.value;
            if (compare == 0) {
                return coordinate.compareTo(o.coordinate);
            }
            return compare;
        }
    }

    class Coordinate implements Comparable<Coordinate> {
        int i, j;

        Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }

        @Override
        public int compareTo(Coordinate o) {
            int deltaI = i - o.i;
            if (deltaI == 0) {
                return j - o.j;
            } else {
                return deltaI;
            }


        }
    }
}
