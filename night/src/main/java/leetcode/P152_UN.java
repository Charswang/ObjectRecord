package leetcode;

/**
 * 2021-11-1
 * 要关注子数组问题；最大子数组之和；最大子数组乘积等
 */
public class P152_UN {
    public static void main(String[] args) {
        int[] nums = {-2,0,-1,-4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int mmin = 1;
        int mmax = 1;
        for (int i = 0;i < len;i++){
            if (nums[i]<0){
                int temp = mmin;
                mmin = mmax;
                mmax = temp;
            }
            mmin = Math.min(nums[i],mmin*nums[i]);
            mmax = Math.max(nums[i],mmax*nums[i]);
            max = Math.max(max,mmax);
        }
        return max;
    }
    public static int maxProduct1(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        int max = dp[0][0];
        for (int i = 0;i<len;i++){
            dp[i][i] = nums[i];
        }
        for (int i = 0;i < len;i++){
            for (int j = i+1;j<len;j++){
                dp[i][j] = (dp[i][j-1]*dp[j][j])>dp[j][j]?(dp[i][j-1]*dp[j][j]):dp[j][j];
                if (max<dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
