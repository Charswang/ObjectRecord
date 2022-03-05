package leetcode;

import org.apache.commons.math3.analysis.function.Max;

/**
 * 2022-3-5
 * 每日一题
 */
public class P2104 {
    /**
     * 暴力
     * @param nums 参数数组
     * @return res
     */
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }
}
