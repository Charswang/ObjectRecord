package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 2021-12-19
 * 每日一题
 */
public class P997 {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < trust.length; i++) {
            if (map.containsKey(trust[i][0])) {
                Set<Integer> set = map.get(trust[i][0]);
                set.add(trust[i][1]);
                map.put(trust[i][0],set);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(trust[i][1]);
                map.put(trust[i][0],set);
            }
        }
        if (map.keySet().size()==(n-1)){
            // map中不存在的数字
            int a = 0;
            for (int i = 1;i <= n;i++){
                if (!map.keySet().contains(i)){
                    a = i;
                    break;
                }
            }
            // 看是否都相信a
            for (Map.Entry<Integer, Set<Integer>> integerSetEntry : map.entrySet()) {
                if (!integerSetEntry.getValue().contains(a)){
                    return -1;
                }
            }
            return a;
        }
        return -1;
    }
}
