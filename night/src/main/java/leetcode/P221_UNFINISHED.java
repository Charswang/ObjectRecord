package leetcode;

/**
 * 2021-11-8
 */
public class P221_UNFINISHED {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        // 最大边长
        int max = 0;
        // 看以matrix[i][j]为右下角的正方形是否存在，如果==0，那肯定不存在；如果==1，那就看左边，上边和左上方的三个点分别为正方形的右下角的时候的最大变长，再加上1
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                max = dp[i][j] > max ? dp[i][j] : max;
            }
        }
        // 返回的是面积
        return max*max;
    }
}
