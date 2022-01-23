package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021-11-14
 * 每日一题
 */
public class P677 {
    private Map<String,Integer> map;
    public P677() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (String s : map.keySet()) {
            if (s.startsWith(prefix)){
                res+=map.get(s);
            }
        }
        return res;
    }
}
