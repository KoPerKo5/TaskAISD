package ru.vsu.cs.perepechko;

import ru.vsu.cs.util.SwingUtils;

public class Node<T> {
    public Node<T> getLeft() {
        return left;
    }

    private Node<T> left;

    public Node<T> getRight() {
        return right;
    }

    public T getData() {
        return data;
    }

    private Node<T> right;
    private T data;

    // standard getters and setters
    public boolean equals(Node<T> root1, Node<T> root2) {
        boolean rootEqual = false;
        boolean lEqual = false;
        boolean rEqual = false;

        if (root1 != null && root2 != null) {
            rootEqual = root1.getData().equals(root2.getData());

            if (root1.getLeft()!=null && root2.getLeft() != null) {
                // compare the left
                lEqual = equals(root1.getLeft(), root2.getLeft());
            }
            else if (root1.getLeft() == null && root2.getLeft() == null) {
                lEqual = true;
            }
            if (root1.getRight() != null && root2.getRight() != null) {
                // compare the right
                rEqual = equals(root1.getRight(), root2.getRight());
            }
            else if (root1.getRight() == null && root2.getRight() == null) {
                rEqual = true;
            }

            return (rootEqual && lEqual && rEqual);
        }
        return false;
    }

    public static void comp(int[] d1, int [] d2) {
        int c = 0;
        for (int i = 0; i < d1.length; i++) {
            if (d1[i] != d2[i]) {
                SwingUtils.showInfoMessageBox("Деревье не эквиваленты");
                c++;
                break;
            }
        } if (c == 0) SwingUtils.showInfoMessageBox("Деревье эквиваленты");
    }
}





