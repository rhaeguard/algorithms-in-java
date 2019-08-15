package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mensur Owary
 */
public class WaysToTraverseAGrid {

    public static void main(String[] args) {
        waysToTraverseRecursive(10,10);
        waysToTraverseRecursiveDP(10,10);
    }

    private static void waysToTraverseRecursive(int n, int m) {
        int a = doWaysToTraverseRecursive(1, n, m, 0);
        System.out.println(a);
    }

    /**
     *
     * Basic idea:
     *
     * We have to traverse the entire tree formed from n x m table. Example.
     *
     * n = 3, m = 3
     * Table :
     *
     * 1 - 2 - 3
     * 4 - 5 - 6
     * 7 - 8 - 9
     *
     * Here's the possible paths... it is a tree.
     * 1 - 2 - 3 - 6 - 9
     *       - 5 - 6 - 9
     *           - 8 - 9
     *   - 4 - 7 - 8 - 9
     *       - 5 - 6 - 9
     *           - 8 - 9
     *  So basically, we count how many times we reach 9.
     *  Rules are we can't move outside of the table.
     *
     *  Row border detection while moving right:
     *      rowNo = ((c - 1) / m) + 1   : c > 0; it denotes current node
     *      rowBorder = rowNo * m
     */
    private static int doWaysToTraverseRecursive(int c, int n, int m, int level) {
        if (c != n * m) {
            System.out.println(getTabs(level) + c); //  to visualize
            int s1 = 0, s2 = 0;
            if ( (c+1) <= ((c - 1) / m + 1) * m )  {
                s1 = doWaysToTraverseRecursive(c + 1, n, m, level+1);
            }
            if (c+m <= n * m) {
                s2 = doWaysToTraverseRecursive(c + m, n, m, level+1);
            }
            return s1 + s2;
        }else {
            System.out.println(getTabs(level) + c); // to visualize
            // return 1, because each time we see "n*m" means that we have found a path.
            return 1;
        }
    }

    private static String getTabs (int level) {
        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < level; i++) {
            tabs.append(" | ");
        }
        return tabs.toString();
    }

    private static void waysToTraverseRecursiveDP(int n, int m) {
        Map<Integer, Integer> cache = new HashMap<>();
        int a = doWaysToTraverseRecursiveDP(1, n, m, 0, cache);
        System.out.println(a);
    }

    /**
     *
     * Extending the explanation provided above, we see that some paths are repeated multiple times
     *
     * The tree:
     *
     * 1 - 2 - 3 - 6 - 9
     *       - 5 - 6 - 9
     *           - 8 - 9
     *   - 4 - 7 - 8 - 9
     *       - 5 - 6 - 9
     *           - 8 - 9
     *
     * Repeated routes: (in big tables, it will contain more.
     *
     * 8 - 9
     * 6 - 9
     */
    private static int doWaysToTraverseRecursiveDP(int c, int n, int m, int level, Map<Integer, Integer> cache) {
        // if we have seen it, return the result
        Integer integer = cache.get(c);
        if (integer != null) {
            return integer;
        }
        if (c != n * m) {
            System.out.println(getTabs(level) + c); //  to visualize
            int s1 = 0, s2 = 0;
            if ( (c+1) <= ((c - 1) / m + 1) * m )  {
                s1 = doWaysToTraverseRecursiveDP(c + 1, n, m, level+1, cache);
            }
            if (c+m <= n * m) {
                s2 = doWaysToTraverseRecursiveDP(c + m, n, m, level+1, cache);
            }
            int res = s1 + s2;
            // save the result
            cache.put(c, res);
            return res;
        }else {
            System.out.println(getTabs(level) + c); // to visualize
            return 1;
        }
    }

}
