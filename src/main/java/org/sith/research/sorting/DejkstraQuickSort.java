package org.sith.research.sorting;


public class DejkstraQuickSort<T extends Comparable> extends AbstractSort<T> {

    public void sort(T[] input) {

        sort(input, 0, input.length - 1);
    }

    private void sort(T[] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo;
        int gt = hi;

        Comparable vo = array[lo];
        int i = lo;

        while (i <= gt) {


            int cmp = array[i].compareTo(vo);

            if (cmp < 0) {
                exchange(array, lt++, i++);
            } else if (cmp > 0) {
                exchange(array, i, gt--);
            } else {
                i++;
            }

        }
        print(array);

        sort(array, lo, lt - 1);
        sort(array, gt + 1, hi);
    }


}
