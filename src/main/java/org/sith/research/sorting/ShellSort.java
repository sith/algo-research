package org.sith.research.sorting;


public class ShellSort<T extends Comparable> extends AbstractSort<T> {
    @Override
    public void sort(T[] input) {

        int[] h = new int[]{4, 3, 1};


        for (int hSort : h) {


            for (int i = 0; i < input.length; i++) {
                T minValue = input[i];
                int minIndex = i;
                for (int j = i+hSort; j < input.length; j += hSort) {
                    T t = input[j];
                    if (t.compareTo(minValue) < 0) {
                        minValue = t;
                        minIndex = j;
                    }
                }
                exchange(input, minIndex, i);
            }
            print(input);
        }
    }
}
