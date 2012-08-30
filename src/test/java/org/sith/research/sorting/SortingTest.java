package org.sith.research.sorting;

import org.junit.Test;


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
        Character[] input = {'c', 'd', 'a', 'w', 'e'};
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

        QuickSort sort = new QuickSort();
        Character[] input = {'c', 'd', 'a', 'w', 'e'};
        sort.sort(input);
        System.out.println();
        for (Character integer : input) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }


}
