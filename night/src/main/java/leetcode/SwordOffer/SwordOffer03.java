package leetcode.SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 2022-2-9
 * 剑指offer
 * 可以延伸为：时间要求O(n)/O(1),空间要求O(n)/O(1)
 */
public class SwordOffer03 {
    public int findRepeatNumber(int[] nums) {
        /*Arrays.sort(nums);
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;*/
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                return num;
            }
            map.put(num,1);
        }
        return -1;
    }
}
