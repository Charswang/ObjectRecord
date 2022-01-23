package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2021-10-13
 */
public class P128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
//        Arrays.sort(nums);
        int[] temp = new int[set.size()];
        int j = 0;
        for (Integer integer : set) {
            temp[j] = integer;
            j++;
        }
        int[] dp = new int[set.size()];
        int max = 1;
        for (int i = 0; i < temp.length; i++) {
            dp[i] = 1;
            if (i == 0) {
                continue;
            }
            if (temp[i] == (temp[i - 1] + 1)) {
                dp[i] = dp[i - 1] + 1;
            }
            max = max < dp[i] ? dp[i] : max;
        }
        return max;
    }
}
