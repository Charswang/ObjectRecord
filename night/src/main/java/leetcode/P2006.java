package leetcode;

import java.util.HashMap;

/**
 * 2022-2-9
 * 每日一题
 * 注意优化方式，不要暴力
 */
public class P2006 {
    public int countKDifference2(int[] nums, int k) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            res+=map.getOrDefault(nums[i]+k,0)+map.getOrDefault(nums[i]-k,0);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return res;
    }
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0;i < nums.length-1;i++){
            for (int j = i+1;j < nums.length;j++){
                if (Math.abs(nums[i]-nums[j])==k){
                    res++;
                }
            }
        }
        return res;
    }
}
