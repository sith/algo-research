package org.sith.research.datasturcutres;


import java.util.*;

/**
 * Date: 17/09/12
 * Time: 11:46
 *
 * @author <a href="mailto:oleksandr.fedorov@ubs.com">Oleksandr Fedorov</a>
 */
public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T value) {
        root = recursiveInsert(root, value);
    }

    private Node<T> recursiveInsert(Node node, T value) {
        if (node == null) {
            return new Node<T>(value);
        }

        if (node.value.compareTo(value) > 0) {
            node.left = recursiveInsert(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = recursiveInsert(node.right, value);
        } else {
            return node;
        }

        return node;
    }


    public Iterator<T> levelOrder() {
        List<T> result = new ArrayList<T>();

        if (root == null) {
            return result.iterator();
        }

        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);

        while (queue.size() > 0) {
            Node<T> poll = queue.poll();
            result.add(poll.value);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return result.iterator();
    }


    public void delete(T value) {
        root = recursiveDelete(root, value);
    }

    private Node<T> recursiveDelete(Node<T> node, T value) {
        if (node.value.compareTo(value) > 0) {
            node.left = recursiveDelete(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = recursiveDelete(node.right, value);
        } else {
            node = makeDelete(node);
        }
        return node;
    }

    private Node<T> makeDelete(Node<T> node) {

        Node<T> right = node.right;
        Node<T> left = node.left;
        if (right == null) {
            return left;
        }

        if (left == null) {
            return right;
        }

        Node<T> lstLeft = findLastLeft(right);

        lstLeft.left = left;

        return right;
    }

    private Node<T> findLastLeft(Node<T> right) {

        if (right.left == null) {
            return right;
        }
        return findLastLeft(right.left);
    }


    public void rotateLeft(Node<T> parent) {
        throw new UnsupportedOperationException();
    }

    public void rotateRight(Node<T> node) {
        throw new UnsupportedOperationException();
    }


    class Node<T extends Comparable<T>> {

        public static final boolean RED = true;
        public static final boolean BLACK = false;


        T value;
        Node<T> left;
        Node<T> right;
        boolean color = RED;

        Node(T value) {
            this.value = value;
        }


    }


}

