package leetcode.competition.medium;

import java.util.Arrays;

public class P5904 {
    public int countMaxOrSubsets(int[] nums) {
        Arrays.sort(nums);
        int max = nums[0];
        int res = 0;
        for (int i = 1;i < nums.length;i++){
            int a = nums[i] | nums[i - 1];
            if (a==max){
                res = (int) Math.pow(2,nums.length-i+1)-1;
            }else {
                max = a;
                res = 1;
            }
        }
        return res;
    }
}
