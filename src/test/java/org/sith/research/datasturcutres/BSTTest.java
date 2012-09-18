package org.sith.research.datasturcutres;

import junit.framework.TestCase;


public class BSTTest extends TestCase {


    public void test() throws Exception {

        BST<Character, Character> bst = new BST<Character, Character>();

//V B R K S E M T O N
        bst.put('V', 'V');
        bst.put('B', 'B');
        bst.put('R', 'R');
        bst.put('K', 'K');
        bst.put('S', 'S');
        bst.put('E', 'E');
        bst.put('M', 'M');
        bst.put('T', 'T');
        bst.put('O', 'O');
        bst.put('N', 'N');


        Character l = bst.get('L');
        System.out.println(l);

    }

    public void test2() throws Exception {

        BST<Character, Character> bst = new BST<Character, Character>();

//F W N P Q T X U Y R
        bst.put('F', 'F');
        bst.put('W', 'W');
        bst.put('N', 'N');
        bst.put('P', 'P');
        bst.put('Q', 'Q');
        bst.put('T', 'T');
        bst.put('X', 'X');
        bst.put('U', 'U');
        bst.put('Y', 'Y');
        bst.put('R', 'R');

        Iterable<Character> characters = bst.levelOrder();


        for (Character character : characters) {
            System.out.print(character + " ");
        }

    }

    public void test3() throws Exception {

        BST<Character, Character> bst = new BST<>();

//E U P Z K Y H O V F I N
        bst.put('E', 'E');
        bst.put('U', 'U');
        bst.put('P', 'P');
        bst.put('Z', 'Z');
        bst.put('K', 'K');
        bst.put('Y', 'Y');
        bst.put('H', 'H');
        bst.put('O', 'O');
        bst.put('V', 'V');
        bst.put('F', 'F');
        bst.put('I', 'I');
        bst.put('N', 'N');


        bst.delete('I');
        bst.delete('O');
        bst.delete('U');


        Iterable<Character> characters = bst.levelOrder();


        for (Character character : characters) {
            System.out.print(character + " ");
        }

    }
}
