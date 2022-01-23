package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2021-11-8
 */
public class P215_UN {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k+1];

        // 2、手写排序算法。要练习的
    }
}
