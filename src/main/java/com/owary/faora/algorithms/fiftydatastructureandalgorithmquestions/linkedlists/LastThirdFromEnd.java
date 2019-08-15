package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.linkedlists;

/**
 * @author Mensur Owary
 */
public class LastThirdFromEnd {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        LiNode n9 = new LiNode(9, null);
        LiNode n8 = new LiNode(3, n9);
        LiNode n7 = new LiNode(4, n8);
        LiNode n6 = new LiNode(2, n7);
        LiNode n5 = new LiNode(5, n6);
        LiNode n4 = new LiNode(4, n5);
        LiNode n3 = new LiNode(3, n4);
        LiNode n2 = new LiNode(2, n3);
        LiNode n1 = new LiNode(1, n2);

        System.out.println(lastThirdNode(n1));
    }

    private static LiNode lastThirdNode (LiNode head) {
        try {
            while (head != null) {
                if (head.next.next.next == null) {
                    return head;
                }
                head = head.next;
            }
        } catch (NullPointerException ignored) {}
        return null;
    }



}
