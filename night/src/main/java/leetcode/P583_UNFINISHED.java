package leetcode;

/**
 * 2021-9-28
 * 2021-9-25的每日一题
 */
public class P583_UNFINISHED {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        // dp[i][j] = dp[i-1][j-1]+1  if(a[i]==b[j])
        // dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char char1 = word1.charAt(i - 1);
            for (int j = 1;j<=len2;j++){
                char char2 = word2.charAt(j-1);
                if (char1==char2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int a = dp[len1][len2];
        return len1+len2-2*a;
    }
}
