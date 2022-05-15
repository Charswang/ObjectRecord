package leetcode.SwordOffer;

/**
 * 2022-5-14
 * 减绳子：动态规划
 * 首先要至少将绳子减成两段，然后后面那一段选择继续减或者不继续减
 */
public class SwordOffer14_no {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
