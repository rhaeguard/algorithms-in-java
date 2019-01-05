package com.owary.faora.datastructures.trees.binarysearchtree;

public class BSTTest {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.contains(5);
        bst.add(6);
        bst.add(5);
        bst.add(1);
        bst.add(56);
        bst.add(-3);

        bst.inorder();

        bst.delete(6);

        bst.inorder();
//        System.out.println(bst.search(5));

//        System.out.println(bst.max());
//        System.out.println(bst.min());
    }

}
