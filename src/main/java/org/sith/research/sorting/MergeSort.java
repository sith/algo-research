package org.sith.research.sorting;


public class MergeSort {


    public void sort(Comparable[] input) {

        Comparable[] aux = new Comparable[input.length];

        sort(input, aux, 0, input.length - 1);


    }

    private void sort(Comparable[] input, Comparable[] aux, int lo, int hi) {


        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(input, aux, lo, mid);
        sort(input, aux, mid + 1, hi);
        if (input[mid + 1].compareTo(input[mid]) > 0) {
            return;
        }
        merge(input, aux, lo, mid, hi);
        print(input);


    }

    protected void print(Comparable[] input) {

        for (Comparable t : input) {
            System.out.print(t + " ");
        }
        System.out.println();

    }

    private void merge(Comparable[] input, Comparable[] aux, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = input[i];
        }

        int k = lo;
        int i = lo;
        int j = mid + 1;


        while (k <= hi) {
            if (i > mid) {
                input[k] = aux[j];
                j++;
            } else if (j > hi) {
                input[k] = aux[i];
                i++;
            } else if (aux[i].compareTo(aux[j]) < 0) {
                input[k] = aux[i];
                i++;
            } else {
                input[k] = aux[j];
                j++;
            }
            k++;
        }
    }
}
