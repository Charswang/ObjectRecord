package leetcode;

import java.util.Arrays;

/**
 * 201-11-6
 * 每日一题
 */
public class P268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
    public int missingNumber1(int[] nums) {
        int res = nums.length;
        for (int i = 0;i < nums.length;i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
