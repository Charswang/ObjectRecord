package leetcode;

/**
 * 2021-9-20 每日一题
 */
public class P673_UNFINISHED {
    public static void main(String[] args) {

    }

    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len]; // 以nums[i]结尾的子序列长度
        int[] counts = new int[len]; // 以nums[i]结尾的相同子序列长度的子序列个数
        int max_len = 0;
        int res = 0;
        for (int i = 0;i < len;i++){
            dp[i] = 1;
            counts[i] = 1;
            for (int j = 0;j < i;j++){
                if (nums[i]>nums[j] && dp[j]+1>dp[i]){
                    dp[i] = dp[j] +1;
                    counts[i] = counts[j]; // 重新计数
                }else if ((dp[j]+1)==dp[i]){ // 注意这里的计算相同序列长度的个数
                    counts[i] += counts[j];
                }
            }
            if (max_len<dp[i]){
                max_len = dp[i];
                res = counts[i];
            }else if (max_len==dp[i]){
                res+=counts[i];
            }

        }
        /*for (int i = 0;i < len;i++){
            if (max_len==dp[i]){
                res += counts[i];
            }
        }*/
        return res;
    }
}
