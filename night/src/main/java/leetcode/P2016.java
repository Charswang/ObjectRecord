package leetcode;

/**
 * 2022-2-26
 * 每日一题
 * 类似买卖股票的最佳时机
 */
public class P2016 {
    public int maximumDifference(int[] nums) {
        int res = -1;
        int min = nums[0];
        int max = res;
        for (int i = 1;i < nums.length;i++){
            if (nums[i]>min){
                res = nums[i] - min;
                max = Math.max(res,max);
            }else {
                min = Math.min(min,nums[i]);
            }

        }
        return max;
    }
}
