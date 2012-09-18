package org.sith.research.datasturcutres;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sith
 * Date: 9/18/12
 * Time: 8:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectionTree<T> {

    Node<T> root;


    public void insert(int lo, int hi, T value) {


        root = recursiveInsert(root, lo, hi, value);

    }

    private Node<T> recursiveInsert(Node<T> node, int lo, int hi, T value) {

        if (node == null) {
            return new Node<>(lo, hi, value);
        }


        if (node.lo > lo) {
            node.left = recursiveInsert(node.left, lo, hi, value);
            checkMaxValue(node, node.left.maxValue);
        } else {
            node.right = recursiveInsert(node.right, lo, hi, value);
            checkMaxValue(node, node.right.maxValue);
        }

        return node;
    }


    public Iterator<T> levelOrder() {

        Queue<Node<T>> nodes = new LinkedList<Node<T>>();
        List<T> values = new ArrayList<>();

        if (root == null) {
            return values.iterator();
        }

        nodes.add(root);
        while (nodes.size() > 0) {
            Node<T> poll = nodes.poll();
            values.add(poll.value);


            if (poll.left != null) {
                nodes.add(poll.left);
            }

            if (poll.right != null) {
                nodes.add(poll.right);
            }
        }
        return values.iterator();
    }

    public boolean isIntersect(int lo, int hi) {

        return recursiveIntersect(root, lo, hi);


    }

    private boolean recursiveIntersect(Node node, int lo, int hi) {

        if (node == null) {
            return false;
        }

        System.out.println("Node " + node.value);

        if (node.isIntersect(lo, hi)) {
            return true;
        }


        if (node.left == null) {
            return recursiveIntersect(node.right, lo, hi);
        }
        if (node.left.maxValue >= lo) {
            return recursiveIntersect(node.left, lo, hi);
        } else {
            return recursiveIntersect(node.right, lo, hi);
        }

    }


    private void checkMaxValue(Node node, int maxValue) {
        if (maxValue > node.maxValue) {
            node.maxValue = maxValue;
        }
    }


    class Node<T> {
        int lo, hi;
        int maxValue;
        T value;

        Node left, right;

        Node(int lo, int hi, T value) {
            this.lo = lo;
            this.hi = hi;
            maxValue = hi;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "lo=" + lo +
                    ", hi=" + hi +
                    ", maxValue=" + maxValue +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }


        public boolean isIntersect(int lo, int hi) {
            return (isBetween(lo)) || isBetween(hi);
        }

        private boolean isBetween(int hi) {
            return hi >= this.lo && hi <= this.hi;
        }
    }


}
