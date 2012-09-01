package org.sith.research.common;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: sith
 * Date: 9/1/12
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Frame<T> implements Iterable<T> {

    final int size;

    private LinkedList<T> list = new LinkedList<>();

    public Frame(int size) {
        this.size = size;
    }


    public void add(T t) {
        list.addLast(t);
        if (list.size() > size) {
            list.removeFirst();
        }
    }


    public T get(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void remove(int i) {
        list.remove(i);
    }
}
