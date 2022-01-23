package leetcode;

/**
 * 2022-1-13
 * 每日一题
 */
public class P747 {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int oneDa = Integer.MIN_VALUE;
        int twoDa = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > oneDa) {
                twoDa = oneDa;
                oneDa = nums[i];
                res = i;
            } else if (nums[i] > twoDa) {
                twoDa = nums[i];
            }
        }
        if (oneDa >= twoDa * 2) {
            return res;
        }
        return -1;
    }
}
