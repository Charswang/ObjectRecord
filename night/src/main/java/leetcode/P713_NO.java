package leetcode;

import com.google.gson.internal.$Gson$Preconditions;

public class P713_NO {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 0;
        System.out.println(numSubarrayProductLessThanK(nums,k));
    }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int left = 0;
        int product = 1;
        int res = 0;
        if (k<=1||nums.length<1){
            return 0;
        }
        for (int right = 0;right < nums.length;right++){
            product *= nums[right];
            while (product>=k){
                product /= nums[left++];
            }
            res += right-left+1;
        }
        return res;
    }

    /**
     * 超出内存限制
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0;j < nums.length;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int res = 0;
        // 以i结尾的时候
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                res++;
                dp[i][i] = nums[i];
            }
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j][i - 1] < k) {
                    long temp = dp[j][i - 1] * nums[i];
                    if (temp < k) {
                        res++;
                        dp[j][i] = (int)temp;
                    }else{
                        break;
                    }
                }
            }
        }
        return res;
    }
}
