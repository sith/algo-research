package org.sith.research.datasturcutres;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sith
 * Date: 9/18/12
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectionTreeTest {
    @Test
    public void testInsert() throws Exception {


        SelectionTree<Character> tree = new SelectionTree<Character>();


        tree.insert(10, 12, 'A');
        tree.insert(9, 11, 'B');
        tree.insert(11, 14, 'C');
        tree.insert(20, 22, 'D');

        Iterator<Character> characterIterator = tree.levelOrder();


        assertThat(characterIterator.next(), is('A'));
        assertThat(characterIterator.next(), is('B'));
        assertThat(characterIterator.next(), is('C'));

        assertTrue(tree.isIntersect(21, 23));


    }


    @Test
    public void testSearch() throws Exception {


        SelectionTree<Character> tree = new SelectionTree<Character>();


        /*A [ 5, 11]
B [ 9, 26]
C [28, 32]
D [33, 39]
E [22, 37]
F [15, 38]
G [ 0, 30]
H [29, 35]*/
//A G B C E D F H
        tree.insert(5, 11, 'A');
        tree.insert(0, 30, 'G');
        tree.insert(9, 26, 'B');
        tree.insert(28, 32, 'C');
        tree.insert(22, 37, 'E');
        tree.insert(33, 39, 'D');
        tree.insert(15, 38, 'F');
        tree.insert(29, 35, 'H');


        assertTrue(tree.isIntersect(36, 40));


    }
}
