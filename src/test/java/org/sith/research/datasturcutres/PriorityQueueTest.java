package org.sith.research.datasturcutres;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: sith
 * Date: 9/4/12
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class PriorityQueueTest extends TestCase {


    public void test() throws Exception {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10, PriorityQueue.Type.MAX);


        queue.insert(6);
        queue.insert(11);
        queue.insert(10);
        System.out.println(queue);

    }
}
