package leetcode;

import java.util.List;

/**
 * 2021-10-17
 */
public class P139_UNFINISHED {
    public static void main(String[] args) {

    }

    /**
     * 动态规划
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0]=1;
        int max = 0;
        for (String s1 : wordDict) {
            max = max < s1.length() ? s1.length() : max;
        }
        for (int i = 1; i <= len; i++) {
            int start = (i <= max) ? 0 : (i - max);
            for (int j = start; j < i; j++) {
                if (dp[j] == 1 && wordDict.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[len] == 1 ? true : false;
    }

    /**
     * 超时！！！
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        for (String s1 : wordDict) {
            int len = s1.length();
            if (s.length() < len) {
                continue;
            }
            if (s1.equals(s.substring(0, len))) {
                if (s1.equals(s)) {
                    return true;
                }
                boolean b = wordBreak(s.substring(len), wordDict);
                if (b) {
                    return b;
                }
            }
        }
        return false;
    }

}
