package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.regex.Pattern;

/**
 *
 * Given a string with the initial condition of dominoes, where:
 *
 * . represents that the domino is standing still
 * L represents that the domino is falling to the left side
 * R represents that the domino is falling to the right side
 *
 * Figure out the final position of the dominoes. If there are dominoes that get pushed on both ends, the force cancels out and that domino remains upright.
 *
 * Example:
 * Input:  ..R...L..R.
 * Output: ..RR.LL..RR
 *
 * @author Mensur Owary
 */
public class FallingDominoes {

    public static void main(String[] args) {
        System.out.println(fall(".L.R...LR..L.."));
        System.out.println(fall("..R...L..R."));
        System.out.println(fall("....."));
        System.out.println(fall("R...............R"));
    }

    /**
     * NOTE: This is not the best implementation so far.
     *
     * Basic idea:
     * there are 2 patterns:
     *  1. RL -> if encountered, should be neutralized, cause they cancel out each other
     *  2. R.L -> if encountered, should be neutralized, cause force is applied to .(dot) on both sides
     *
     *  We convert these cases to A and B correspondingly so that they won't be affected
     *
     * next,
     * there are 2 more patterns:
     *  1. if R is followed by a dot (.), then it is able to fall over it and make it right
     *  2. if L is preceded by a dot (.), then it is able to fall over it and make it left
     *
     * Since we already cover the cases where (A, B), it is safe to do stuff like "R." or ".L",
     * cause they cannot affect cases like (RR, LL or R.L)
     */
    private static String fall (String pattern) {
        while (shouldRun(pattern)) {
            // base cases
            pattern = pattern.replace("RL", "A")
                             .replace("R.L", "B");

            // normal cases
            pattern  = pattern.replace("R.", "RR")
                              .replace(".L", "LL");
        }
        return pattern
                .replace("A", "RL")
                .replace("B", "R.L");

    }

    private static boolean shouldRun (String pattern) {
        return  pattern.contains("RL")  ||
                pattern.contains("R.L") ||
                pattern.contains("R.")  ||
                pattern.contains(".L");
    }

}

