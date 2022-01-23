package leetcode;

import java.util.Arrays;

/**
 * 2021-11-7
 * 需要进阶算法
 * 设计时间复杂度为O(n),空间复杂度为O(1)的算法  --  打仗对拼，活下来的那个就是结果
 */
public class P169 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int a = nums[0];
        for (int i = 1;i < nums.length;i++){
            if (a==nums[i]){
                count++;
            }else {
                count--;
                if (count==0){
                    a = nums[i+1];
                }
            }
        }
        return a;
    }
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int i = 1;i < nums.length;i++){
            if (nums[i]==nums[i-1]){
                res++;
                if (res>nums.length/2){
                    return nums[i];
                }
            }else{
                res=1;
            }
        }
        return nums[0];
    }
}
