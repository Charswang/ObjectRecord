package leetcode;

/**
 * 给你一个字符串 s，找到 s中最长的回文子串。
 *
 * @author charswang
 * @date 2021-08-14
 */
public class P5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        int begin = 0;
        int end = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        // 需要从字符串长度从小到大进行搜索
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = 0;
                    continue;
                }
                // 1 1 1 1 1
                if (j - i < 3) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] == 1) {
                    max = l;
                    begin = i;
                    end = j;
                }
            }
        }
        return s.substring(begin, end + 1);
    }
}
