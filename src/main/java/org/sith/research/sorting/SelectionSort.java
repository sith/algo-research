package org.sith.research.sorting;

public class SelectionSort<T extends Comparable> extends AbstractSort<T>  {


    @Override
    public void sort(T[] input) {


        for (int i = 0; i < input.length; i++) {
            T minValue = input[i];
            int minIndex = i;
            for (int j = i; j < input.length; j++) {
                T t = input[j];
                if (t.compareTo(minValue) < 0) {
                    minValue = t;
                    minIndex = j;
                }
            }

            exchange(input, i, minIndex);
            print(input);
        }
    }

}
