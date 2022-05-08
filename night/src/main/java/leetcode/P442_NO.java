package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2022-5-8
 * 每日一题
 */
public class P442_NO {
    public static void main(String[] args) {

    }

    // 1、 第一次将当前数字按顺序该在的地方的数字从正数变成负数，
    // 如果是第二次出现的话，按顺序该在的地方的数字是负数了，那么就说明是重复出现的
    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int t = Math.abs(nums[i]);
            if (nums[t - 1] < 0) {
                res.add(t);
            } else {
                nums[t - 1] = -nums[t - 1];
            }
        }
        return res;
    }

    // 2、让每个数字放在与顺序索引一致的地方
    // 然后到最后，没在与顺序索引一直的地方的数字就是结果集合中的元素
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) { // 这里的while？
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                res.add(nums[i]);
            }
        }

        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 3、自己使用了额外空间
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num) && !res.contains(num)) {
                res.add(num);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }
}
