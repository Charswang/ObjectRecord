package leetcode;

/**
 * 2022-1-17
 * 每日一题
 */
public class P1220 {
    public int countVowelPermutation(int n) {
        // a e i o u
        long a = (long) Math.pow(10, 9) + 7;
        long[][] dp = new long[n][5];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < 5; j++) {
                    dp[i][j] = 1;
                }
            } else {
                dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % a;
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % a;
                dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % a;
                dp[i][3] = (dp[i - 1][2]) % a;
                dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % a;
            }
        }
        int sum = (int)((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3] + dp[n - 1][4])%a);
        return sum;
    }
}
