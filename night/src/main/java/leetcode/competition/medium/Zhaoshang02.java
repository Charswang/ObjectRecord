package leetcode.competition.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022-4-17
 */
public class Zhaoshang02 {
    public int numFlowers(int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] road : roads) {
            map.put(road[0], map.getOrDefault(road[0], 0) + 1);
            map.put(road[1], map.getOrDefault(road[1], 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        return max+1;
    }
}
