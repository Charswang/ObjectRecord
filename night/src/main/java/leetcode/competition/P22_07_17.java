package leetcode.competition;

import java.util.*;

/**
 * 2022-7-17
 *
 * 第二题【maximumSum】-- 简单的，但是自己就是忽略了list的排序来优化时间，导致超出时间限制。。。
 *
 */
public class P22_07_17 {
    public static void main(String[] args) {
        int[] nums = {229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366, 401};
        int i = maximumSum(nums);
        System.out.println(i);
    }

    public static int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            res[0] += value / 2;
            res[1] += value % 2;
        }
        return res;
    }

    public static int maximumSum(int[] nums) {
        int res = -1;
        int[] temp = new int[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            temp[i] = getSum(nums[i]);
            if (map.containsKey(temp[i])) {
                List<Integer> integers = map.get(temp[i]);
                integers.add(nums[i]);
                map.put(temp[i], integers);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(temp[i], list);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() < 2) {
                continue;
            } else {
                Collections.sort(value);
                res = Math.max(res, value.get(value.size() - 1) + value.get(value.size() - 2));
            }
        }
        return res;
    }

    public static int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

}
