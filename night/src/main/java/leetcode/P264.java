package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 2022-5-3
 * 丑数II
 * 丑数：如果有因子是素数，那么这个因子必须是2/3/5
 */
public class P264 {
    public static void main(String[] args) {

    }
    public int nthUglyNumber(int n) {
        // 小根堆
        PriorityQueue<Long> p = new PriorityQueue<>();
        // 大根堆
        // PriorityQueue<Long> q = new PriorityQueue<>(Collections.reverseOrder());
        p.add(1L);
        int ugly_n = 1;
        int[] factors = {2,3,5};
        Set<Long> set = new HashSet<>();
        set.add(1L);
        for (int i = 0; i < n; i++) {
            long poll = p.poll();
            for (int factor : factors) {
                if (set.add(factor*poll)){
                    p.add(factor*poll);
                }
            }
            ugly_n = (int) poll;
        }
        return ugly_n;
    }
}
