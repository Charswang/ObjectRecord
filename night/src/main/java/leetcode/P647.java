package leetcode;

import java.util.Arrays;

/**
 * 2021-12-12
 * 回文子串
 */
public class P647 {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int sum=0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            sum++;
            for (int j = i-1; j >= 0; j--) {
                if (j==i-1 && s.charAt(j)==s.charAt(i)){
                    dp[j][i]=1;
                    sum++;
                } else if (dp[j+1][i-1]==1 && s.charAt(j)==s.charAt(i)){
                    dp[j][i]=1;
                    sum++;
                }
            }
        }
        return sum;
    }
}
