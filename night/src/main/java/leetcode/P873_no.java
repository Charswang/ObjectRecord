package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022-7-9
 * 每日一题
 * <p>
 * 确定以下标i、j为后两位的斐波那契数列的数字个数
 */
public class P873_no {
    public int lenLongestFibSubseq(int[] arr) {
        // 首先要确定arr中每个数字的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        // 然后使用dp，确定以下标i、j为后两位的斐波那契数列的数字个数
        int[][] dp = new int[arr.length][arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                // 上面for循环中：
                // 因为数组是递增的，如果arr[j] * 2 <= arr[i]，那么必定没有符合要求的数据
                if (map.containsKey(arr[i] - arr[j])) {
                    int k = map.get(arr[i] - arr[j]);
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                res = Math.max(res,dp[j][i]);
            }
        }
        return res;
    }
}
