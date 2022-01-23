package leetcode;

/**
 * 2022-1-3
 * 动态规划？--yes
 *
 * 1、当前位置的数单独匹配【前提是不为0】：dp[i] = dp[i-1];
 * 2、当前位置的数可以和前面的一个数匹配【如果可以的话】：dp[i] = dp[i-2];
 * dp[i] = ①+②  【1和2中获取到的dp[i]相加】
 */
public class P91 {
    public int numDecodings(String s) {
        int len = s.length();
        if (s.charAt(0)=='0'){
            return 0;
        }
        int[] dp = new int[len+1];
        dp[0] = 1; // 为了方便动态规划手动设置
        dp[1] = 1;
        for (int i = 1;i < len;i++){
            // 忘了这里的dp长度是len+1了，所以这里探索dp的时候j要比s中的i要多1
            int j = i+1;
            if (s.charAt(i)!='0'){
                // 单个匹配
                dp[j] = dp[j-1];
                // 与前一个是否能结合
                if (s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && Integer.parseInt(s.substring(i,i+1))<7)){
                    dp[j] += dp[j-2];
                }
            }else{
                // 单个匹配不可能，只需要看能不能和前面的一个数字进行结合
                // 与前一个是否能够匹配
                if (s.charAt(i-1)=='1' || s.charAt(i-1)=='2'){
                    dp[j] = dp[j-2];
                }else{
                    return 0;
                }
            }
        }
        return dp[len];
    }
}
