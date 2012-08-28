package org.sith.research.sorting;


public class InsertionSort<T extends Comparable> extends AbstractSort<T> {
    @Override
    public void sort(T[] input) {
        for (int i = 0; i < input.length; i++) {

            for (int j = i; j > 0; j--) {
                if (input[j].compareTo(input[j-1]) > 0) {
                    break;
                }
                exchange(input, j, j - 1);
                print(input);
            }
        }
    }
}
