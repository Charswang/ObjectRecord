package leetcode;

import java.util.Arrays;

/**
 * 2021-9-10  没做出来
 *
 * 2021-9-23  做出来了，不过内存消耗和运行时间有点low
 */
public class P41 {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int t = 1;
        for (int i = 0;i < nums.length;i++){
            if (nums[i]<=0){
                count++;
                continue;
            }

            if (nums[i]!=t){
                if (i>0 && nums[i]==nums[i-1]){
                    continue;
                }else{
                    return t;
                }
            }
            t++;
        }
        return t;
    }
}
