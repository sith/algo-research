package org.sith.research.sorting;


public class QuickSort<T extends Comparable> extends AbstractSort<T> {

    public void sort(T[] input) {

        sort(input, 0, input.length - 1);
    }

    private void sort(T[] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int partition = partition(array, lo, hi);
        print(array);
        sort(array, lo, partition - 1);
        sort(array, partition + 1, hi);
    }


    private int partition(T[] array, int lo, int hi) {

        int i = lo;
        int j = hi + 1;


        while (true) {

            while (array[++i].compareTo(array[lo]) < 0) {
                if (i == hi) {
                    break;
                }
            }

            while (array[lo].compareTo(array[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exchange(array, i, j);
        }
        exchange(array, lo, j);


        return j;

    }

    protected void exchange(T[] input, int to, int from) {
        T tmp = input[to];
        input[to] = input[from];
        input[from] = tmp;

    }
}
