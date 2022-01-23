package leetcode;

public class P300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int i1 = dp[j];
                    max = i1 > max ? i1 : max;
                }
            }
            dp[i] = max + 1;
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
