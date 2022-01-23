package leetcode;

/**
 * 跳跃问题II -- 想成了dp问题
 *
 * @author charswang
 * @since 2021-8-29
 */
public class P45 {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4}; //1 2 2 3 3
        int[] nums = {2,3,0,1,4}; //1 2 2 3 3
        System.out.println(jump(nums));
    }

    // dp问题吧，应该。
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = (i + nums[i]) <nums.length ? (i + nums[i]) : (nums.length-1);
            for (int t = i+1;t<=temp;t++){
                if (dp[t] != 0) {
                    dp[t] = Math.min(dp[i] + 1, dp[t]);
                } else {
                    dp[t] = dp[i] + 1;
                }
            }
        }
        /*for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }*/
        return dp[nums.length-1];
    }
}
