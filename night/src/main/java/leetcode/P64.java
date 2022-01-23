package leetcode;

/**
 * 2021-10-13
 * dp
 */
public class P64 {
    // dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1]
    public int minPathSum(int[][] grid) {
        int len1 = grid.length;
        int len2 = grid[0].length;
        int[][] dp = new int[len1][len2];
        dp[0][0] = grid[0][0];
        for (int i = 1;i < len1;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1;i<len2;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1;i < len1;i++){
            for (int j = 1;j < len2;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[len1-1][len2-1];
    }
}
