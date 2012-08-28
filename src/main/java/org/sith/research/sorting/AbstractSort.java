package org.sith.research.sorting;

/**
 * Created with IntelliJ IDEA.
 * User: sith
 * Date: 8/26/12
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractSort<T extends Comparable> implements Sorting<T> {

    protected void exchange(T[] input, int to, int from) {
        T tmp = input[to];
        input[to] = input[from];
        input[from] = tmp;

    }

    protected void print(T[] input) {

        for (T t : input) {
            System.out.print(t + " ");
        }
        System.out.println();

    }
}
