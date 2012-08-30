package org.sith.research.datasturcutres;

import junit.framework.TestCase;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: sith
 * Date: 8/28/12
 * Time: 9:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class DequeTest extends TestCase {


    public void test1() throws Exception {

        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertThat(deque.size(), is(3));
        assertThat(deque.removeFirst(), is(3));
        assertThat(deque.size(), is(2));
        assertThat(deque.removeFirst(), is(2));
        assertThat(deque.size(), is(1));
        assertThat(deque.removeFirst(), is(1));

    }


    public void test2() throws Exception {

        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertThat(deque.size(), is(3));
        assertThat(deque.removeFirst(), is(1));
        assertThat(deque.size(), is(2));
        assertThat(deque.removeFirst(), is(2));
        assertThat(deque.size(), is(1));
        assertThat(deque.removeFirst(), is(3));

    }

    public void test3() throws Exception {

        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addFirst(2);
        deque.addLast(3);
        assertFalse(deque.isEmpty());
        assertThat(deque.size(), is(3));
        assertThat(deque.removeFirst(), is(2));
        assertFalse(deque.isEmpty());
        assertThat(deque.size(), is(2));
        assertThat(deque.removeFirst(), is(1));
        assertFalse(deque.isEmpty());
        assertThat(deque.size(), is(1));
        assertThat(deque.removeFirst(), is(3));
        assertTrue(deque.isEmpty());

    }

    public void test4() throws Exception {

        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addFirst(2);
        deque.addLast(3);

        assertThat(deque.size(), is(3));
        assertThat(deque.removeFirst(), is(2));
        assertThat(deque.size(), is(2));
        assertThat(deque.removeLast(), is(3));
        assertThat(deque.size(), is(1));
        assertThat(deque.removeFirst(), is(1));

    }


    public void test5() throws Exception {

        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addFirst(2);
        deque.addLast(3);


        Iterator<Integer> iterator = deque.iterator();

        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        assertFalse(iterator.hasNext());


        assertFalse(iterator.hasNext());


    }

}
