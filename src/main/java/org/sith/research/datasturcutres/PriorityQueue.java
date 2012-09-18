package org.sith.research.datasturcutres;

import java.util.Comparator;

public class PriorityQueue<T> {

    Comparable<T>[] array;
    private Type type;
    Comparator<Comparable<T>> comparator;

    int N = 0;


    enum Type {
        MAX, MIN
    }

    public PriorityQueue(Comparable<T>[] array, Type type) {
        this.array = array;//copy array +1 element
        this.type = type;
        init(type);

    }

    private void init(Type type) {
        switch (type) {
            case MAX:
                comparator = new MaxComparator<T>();

                break;
            case MIN:
                comparator = new MinComparator<T>();

                break;
            default:
                throw new IllegalStateException("Unsupported type " + type);
        }

    }

    public PriorityQueue(int capacity, Type type) {
        this.type = type;
        array = new Comparable[capacity + 1];
        init(type);
    }


    public void insert(Comparable<T> item) {

        array[++N] = item;

        swim(N);


    }

    private void swim(int index) {

        Comparable<T> parent = array[index / 2];
        Comparable<T> current = array[index];
        while (index > 1 && comparator.compare(parent, current) > 0) {
            array[index / 2] = current;
            array[index] = parent;
            index = index / 2;
        }
    }


    /*private void sink(int index) {
        while (2 * index <= N) {

            int j = 2 * index;

            if (j < N && comparator.compare(array[j], array[j + 1]) > 0)){
                j++;
            }

            if () {
            }

        }
    }*/


    private int getParentIndex(int index) {
        return log2(index).intValue();
    }

    private Double log2(int value) {
        return Math.log(value) / Math.log(2);
    }


    public Comparable<T> poll() {
        return null;
    }

    public Comparable<T> peek() {
        return null;
    }

    public boolean isEmpty() {
        return N == 0;
    }


    public int size() {
        return N;
    }

    private static class MaxComparator<T> implements Comparator<Comparable<T>> {
        @Override
        public int compare(Comparable o1, Comparable o2) {
            return o2.compareTo(o1);
        }
    }

    private static class MinComparator<T> implements Comparator<Comparable<T>> {
        @Override
        public int compare(Comparable o1, Comparable o2) {
            return o1.compareTo(o2);
        }

    }
}
