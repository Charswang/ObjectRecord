package leetcode;

/**
 * 2022-2-15
 */
public class P53 {
    public int maxSubArray(int[] nums) {
        // dp
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
