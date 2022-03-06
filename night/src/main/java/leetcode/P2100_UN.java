package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-3-6
 * 每日一题
 */
public class P2100_UN {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int len = security.length;
        int[] left = new int[len];
        int[] right = new int[len];
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[len - i - 1] <= security[len - i]) {
                right[len - i - 1] = right[len - i] + 1;
            }
        }
        for (int i = time; i < len - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
