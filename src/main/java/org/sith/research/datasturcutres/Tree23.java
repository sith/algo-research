package org.sith.research.datasturcutres;


public class Tree23<T extends Comparable<T>> {

    private Node<T> root;


    public void insert(T value) {


        root = recursiveInsert(root, value);


    }

    private Node<T> recursiveInsert(Node<T> node, T value) {

        if (node == null) {
            return new Node<T>(value);
        }
        T minValue = node.minValue;
        T maxValue = node.maxValue;


        if (node.is2Node()) {
            if (value.compareTo(minValue) < 0) {
                node.left = recursiveInsert(node.left, value);
            } else {
                node.addSecondValue(value);
            }
        } else if (node.is3Node()) {
            if (value.compareTo(minValue) < 0) {
                node.right = recursiveInsert(node.right, value);
            } else {
                node = node.split(value);
            }
        }
        return node;

    }


    class Node<T extends Comparable<T>> {
        T minValue, maxValue;

        Node<T> left, right, middle;

        Node(T minValue) {
            this.minValue = minValue;
        }


        public boolean is2Node() {
            return maxValue == null && middle == null;
        }

        public boolean is3Node() {
            return maxValue != null && middle == null;
        }

        public void addSecondValue(T value) {
            if (minValue.compareTo(value) > 0) {
                T tmp = minValue;
                minValue = value;
                maxValue = tmp;
            } else {
                maxValue = value;
            }
        }

        public Node<T> split(T value) {


            return null;
        }
    }

}
