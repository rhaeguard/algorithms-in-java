package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author Mensur Owary
 */
public class BSTFloorCeiling {

    public static void main(String[] args) {
        BiNode b3 = new BiNode(3);
        BiNode b5 = new BiNode(5);
        BiNode b8 = new BiNode(8);
        BiNode b12 = new BiNode(12);

        BiNode b4 = new BiNode(b3, b5, 4);
        BiNode b10 = new BiNode(b8, b12, 10);

        BiNode b7root = new BiNode(b4, b10, 7);

        int[] floorAndCeiling = getFloorAndCeiling(b7root, 5);

        System.out.println(Arrays.toString(floorAndCeiling));
    }

    private static int[] getFloorAndCeiling (BiNode root, int target) {
        BiNode floor = null;
        BiNode ceil = null;
        while (root != null) {
            if (target > root.value) {
                floor = root;
                root = root.right;
            }
            else if (target < root.value) {
                ceil = root;
                root = root.left;
            }
            else {
                floor = root;
                ceil = root;
                break;
            }
        }

        return new int[] {
                floor.value,
                ceil.value
        };
    }
}


class BiNode {

    public BiNode left;
    public BiNode right;
    public int value;

    public BiNode(int value) {
        this.value = value;
    }

    public BiNode(BiNode left, BiNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BiNode.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}