package org.sith.research.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;


public class SortingTest {


    @Test
    public void testSelectionSort() {

        SelectionSort<Character> sort = new SelectionSort<Character>();
        Character[] input = {'S', 'K', 'M', 'G', 'V', 'F', 'P', 'I', 'H', 'C'};
        sort.sort(input);
        System.out.println();
        for (Character character : input) {
            System.out.print(character);
        }

    }

    @Test
    public void testInsertionSort() {

        /*
      *  K Q T W Z B O I C R
1: K Q T W B Z O I C R
2: K Q T B W Z O I C R
3: K Q B T W Z O I C R
4: K B Q T W Z O I C R
5: B K Q T W Z O I C R
6: B K Q T W O Z I C R */


        InsertionSort<Character> sort = new InsertionSort<Character>();
        Character[] input = {'E', 'I', 'J', 'O', 'X', 'Q', 'M', 'H', 'L', 'K'};
        sort.sort(input);
        System.out.println();
        for (Character character : input) {
            System.out.print(character);
        }

    }


    @Test
    public void testShellSort() {

        ShellSort<Character> sort = new ShellSort<Character>();
//        Character[] input = {'c', 'd', 'a', 'w', 'e'};
        Character[] input = {'Q', 'X', 'E', 'V', 'F', 'A', 'B', 'K', 'Y', 'W'};
        sort.sort(input);
        System.out.println();
        for (Character character : input) {
            System.out.print(character);
        }

    }

    @Test
    public void testMergeSort() {

        MergeSort sort = new MergeSort();
        Character[] input = {'J', 'E', 'T', 'Y', 'Z', 'V', 'M', 'U', 'B', 'O', 'I', 'G'};
//        Character[] input = {'J', 'I', 'A', 'X', 'C', 'F', 'H', 'Q', 'K', 'Y', 'B', 'R'};
        sort.sort(input);
        /* System.out.println();
        for (Character character : input) {
            System.out.print(character);
        }*/

        /*  B H D Q X O N E J Z Y I
merge(0, 0, 1):  B H D Q X O N E J Z Y I
merge(0, 1, 2):  B D H Q X O N E J Z Y I
merge(3, 3, 4):  B D H Q X O N E J Z Y I
merge(3, 4, 5):  B D H O Q X N E J Z Y I
merge(0, 2, 5):  B D H O Q X N E J Z Y I
merge(6, 6, 7):  B D H O Q X E N J Z Y I
merge(6, 7, 8):  B D H O Q X E J N Z Y I*/


    }

    @Test
    public void testBottomUpMergeSort() {

        BottomUpMergeSort sort = new BottomUpMergeSort();
        Character[] input = {'T', 'H', 'X', 'B', 'F', 'P', 'V', 'E', 'U', 'K'};
//        Character[] input = {'C', 'B', 'D', 'A'};
//        Character[] input = {'C', 'B'};
        sort.sort(input);
        System.out.println();
        for (Character character : input) {
            System.out.print(character);
        }
    }


    @Test
    public void testQuickSort() {
/*


        Integer[] array = new Integer[1000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);

        }
*/


        QuickSort sort = new QuickSort();

//        Integer[] array = new Integer[]{                     1, 3, 2, 2, 5, };

        Character[] array = new Character[]{'N', 'J', 'D', 'R', 'M', 'Z', 'B', 'F', 'P', 'C', 'K', 'U'};
//        Character[] array = new Character[]{'B', 'A', 'A', 'B', 'A', 'B', 'A', 'B', 'B', 'A', 'B', 'A'};
        sort.sort(array);


        /* System.out.println();
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();*/
    }

    @Test
    public void testDejkstraQuickSort() {

        /* Integer[] array = new Integer[1000000];
                Random random = new Random();
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(10000);

                }
        */
        DejkstraQuickSort sort = new DejkstraQuickSort();

//        Integer[] array = new Integer[]{                     1, 3, 2, 2, 5, };

        Character[] array = new Character[]{'N', 'T', 'W', 'N', 'N', 'N', 'X', 'B', 'J', 'Y'};
        sort.sort(array);

        /* for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.println();*/
    }


    @Test
    public void testName() throws Exception {

        Integer[] array = new Integer[10000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);

        }


        int max = Integer.MIN_VALUE;
        long start = System.currentTimeMillis();
        /*for (Integer integer : array) {
            if (integer>max) {
                max = integer;
            }
        }*/
        Arrays.sort(array);
        long finish= System.currentTimeMillis();
        System.out.println(finish-start);
        System.out.println(max);



    }
}
