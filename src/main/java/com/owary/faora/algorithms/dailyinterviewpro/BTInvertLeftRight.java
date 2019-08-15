package com.owary.faora.algorithms.dailyinterviewpro;

/**
 * @author Mensur Owary
 */
public class BTInvertLeftRight {

    public static void main(String[] args) {
        BiNode d = new BiNode(9);
        BiNode e = new BiNode(8);
        BiNode f = new BiNode(10);

        BiNode b = new BiNode(d, e, 3);
        BiNode c = new BiNode(f, null, 2);

        BiNode a = new BiNode(b, c, 1);
        inOrderTraverse(a);

        System.out.println("================");
        invert(a);

        inOrderTraverse(a);
    }

    private static void invert (BiNode root) {
        if (root != null) {
            invert(root.left);
            invert(root.right);

            BiNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }

    private static void inOrderTraverse (BiNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.println(root.value);
            inOrderTraverse(root.right);
        }
    }

}
