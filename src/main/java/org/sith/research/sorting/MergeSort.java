package org.sith.research.sorting;

/**
 * Created with IntelliJ IDEA.
 * User: sith
 * Date: 8/28/12
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {


    public void sort(Comparable[] input) {

        Comparable[] aux = new Comparable[input.length];

        int N = aux.length;
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(input, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    /*public void sort(Comparable[] input) {

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


    }*/

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
