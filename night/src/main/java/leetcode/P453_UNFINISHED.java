package leetcode;

import java.util.Arrays;

/**
 * 2021-10-20
 * 每日一题
 *
 * 数学题，重来一遍
 */
public class P453_UNFINISHED {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum += nums[i] - min;
        }
        return sum;
    }

    /**
     * 超时
     * @param nums
     * @return
     */
    public int minMoves1(int[] nums) {
        int count = 0;
        while(true){
            Arrays.sort(nums);
            int max = nums[nums.length-1];
            boolean flag = true;
            for (int i = 0;i<nums.length-1;i++){
                if (nums[i]!=max){
                    flag = false;
                    count++;
                }
                nums[i]++;
            }
            if (flag){
                return count;
            }
        }
    }
}
