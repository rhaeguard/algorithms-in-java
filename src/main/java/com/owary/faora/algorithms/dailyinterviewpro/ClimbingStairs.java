package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mensur Owary
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new StairCount().stairCount(4)); // 5
        System.out.println(new StairCount().stairCount(5)); // 8
    }

}

class StairCount {

    private Map<Integer, Integer> stairCountCache = new HashMap<>();

    public int stairCount (int steps) {
        if (stairCountCache.containsKey(steps)) {
            return stairCountCache.get(steps);
        }
        if (steps == 0) {
            return 1;
        } else if (steps < 0) {
            return 0;
        }
        int res = stairCount(steps-1) + stairCount(steps-2);
        if (!stairCountCache.containsKey(res)) {
            stairCountCache.put(steps, res);
        }
        return res;
    }

}
