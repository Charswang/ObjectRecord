package leetcode;

import java.util.Arrays;

/**
 * 2021-12-20
 * 每日一题
 * 排序+二分
 * 排序+双指针
 *
 * 早上看的答案大概理解，晚上自己再写
 */
public class P475_UNFINISHED {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        /*for (int i = 0;i < houses.length;i++){
            int a = twoSplit(heaters,houses[i]);
            int b = a+1;
            int left = a<0?Integer.MAX_VALUE:houses[i]-heaters[a];
            int right = b<heaters.length?heaters[b]-houses[i]:Integer.MAX_VALUE;
            int c = Math.min(left,right);
            res = Math.max(res,c);
        }*/


        return res;
    }
    public int twoSplit(int[] nums,int a){
        int left = 0;
        int right = nums.length-1;
        if (nums[left]>a){
            return -1;
        }
        while(left<right){
            // 为什么要加1？？？？
            int mid = left+(right-left)/2;
            if (nums[mid]>a){
                right = mid-1;
            }else {
                left = mid;
            }
        }
        return left;
    }
}
