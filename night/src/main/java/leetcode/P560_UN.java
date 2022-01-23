package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 201-11-28
 *oouoccoouocc
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 */

public class P560_UN {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // /当sum==k的时候的情况
        int res = 0;
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum+=nums[i];
            if (map.keySet().contains(sum-k)){
                res += map.get(sum-k);
            }
            // Map.getOrDefault(Object key, V defaultValue)方法的作用是：
            // 当Map集合中有这个key时，就使用这个key值；
            // 如果没有就使用默认值defaultValue。
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
