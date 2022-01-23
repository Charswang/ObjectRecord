package leetcode;

import java.util.Arrays;

public class P977 {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] ints = sortedSquares(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0;i < nums.length;i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
