package org.sith.research.datasturcutres;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

    private Item<T> first;
    private Item<T> last;
    private int size;

    public Deque() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {

        checkNull(item);

        Item<T> newItem = new Item<T>(item);
        size++;

        if (first == null && last == null) {
            first = newItem;
            last = newItem;
            return;
        }
        newItem.next = first;
        first = newItem;


        Arrays.sort(new Object[10]);

    }

    private void checkNull(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    public void addLast(T item) {
        Item<T> newItem = new Item<T>(item);
        size++;
        if (first == null && last == null) {
            first = newItem;
            last = newItem;
            return;
        }
        newItem.previous = last;
        last.next = newItem;
        last = newItem;

    }

    public T removeFirst() {

        checkEmpty();

        Item<T> first = this.first;

        this.first = first.next;
        if (this.first == null) {
            this.last = null;
        }
        size--;
        return first.value;
    }

    public T removeLast() {


        checkEmpty();


        Item<T> last = this.last;
        this.last = last.previous;

        if (this.last == null) {
            this.first = null;
        }
        size--;
        return last.value;
    }

    private void checkEmpty() {
        if (first == null && last == null) {
            throw new NoSuchElementException();
        }
    }

    public Iterator<T> iterator() {
        return new ObjectIterator<T>(this.first);
    }


    class Item<T> {
        T value;
        private Item<T> next;
        private Item<T> previous;

        public Item(T item) {
            value = item;
        }


        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", next=" + next +
                    ", previous=" + previous +
                    '}';
        }
    }

    private class ObjectIterator<T> implements Iterator<T> {
        private Item<T> item;

        public ObjectIterator(Item<T> item) {
            this.item = item;
        }

        @Override
        public boolean hasNext() {
            return item != null;
        }

        @Override
        public T next() {
            if (item == null) {
                throw new NoSuchElementException();
            }
            T value = item.value;
            item = item.next;

            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}