package org.sith.research.datasturcutres;

import org.junit.Test;


public class RedBlackBSTTest {

    @Test
    public void test2() {

        RedBlackBST<Character, Character> tree = new RedBlackBST();


//     N F V D H R X A E G K Q T
        tree.put('N', 'N');
        tree.put('F', 'F');
        tree.put('V', 'V');
        tree.put('D', 'D');
        tree.put('H', 'H');
        tree.put('R', 'R');
        tree.put('X', 'X');
        tree.put('A', 'A');
        tree.put('E', 'E');
        tree.put('G', 'G');
        tree.put('K', 'K');
        tree.put('Q', 'Q');
        tree.put('T', 'T');


//        Iterable<Character> characters = tree.levelOrder();
        Iterable<Character> characters = tree.levelColorOrder();
        for (Character character : characters) {
            System.out.print(character + " ");
        }
        System.out.println();


    }

    @Test
    public void test3() {

        RedBlackBST<Character, Character> tree = new RedBlackBST();


//    L G R D I O X C F H
        tree.put('L', 'L');
        tree.put('G', 'G');
        tree.put('R', 'R');
        tree.put('D', 'D');
        tree.put('I', 'I');
        tree.put('O', 'O');
        tree.put('X', 'X');
        tree.put('C', 'C');
        tree.put('F', 'F');
        tree.put('H', 'H');


        tree.put('N', 'N');
        tree.put('Z', 'Z');
        tree.put('W', 'W');


        Iterable<Character> characters = tree.levelOrder();

        for (Character character : characters) {
            System.out.print(character + " ");
        }
        System.out.println();


    }

}
