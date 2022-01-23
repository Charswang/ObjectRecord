package leetcode;

import java.util.*;

/**
 * 2021-10-22
 * 每日一题
 *
 * again尝试摩尔投票法--超过一半数量的最多有一个；改进--超过n/3数量的最多有两个
 */
public class P229 {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int l = len/3;
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < len;i++){
            if (map.keySet().contains(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
            if (map.get(nums[i])>l){
                set.add(nums[i]);
            }
        }
        return new ArrayList<>(set);
    }
}
