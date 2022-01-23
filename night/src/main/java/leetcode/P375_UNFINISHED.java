package leetcode;

/**
 * 2021-11-12
 * 每日一题
 */
public class P375_UNFINISHED {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[300][300];
        for (int i = 1;i<=n;i++){
            for (int j = i-1;j>=1;j--){
                dp[j][i] = n*n;
                for (int t = j;t<=i;t++){
                    dp[j][i] = Math.min(dp[j][i],t+Math.max(dp[t+1][i],dp[j][t-1]));
                }
            }
        }
        return dp[1][n];
    }
}
