package leetcode;

import java.util.HashMap;

/**
 * 2022-2-13
 * 每日一题
 */
public class P1189 {
    public int maxNumberOfBalloons(String text) {
        char[] chars = text.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int n = map.getOrDefault('n', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        return Math.min(b,Math.min(a,Math.min(n,Math.min(l,o))));
    }
}
