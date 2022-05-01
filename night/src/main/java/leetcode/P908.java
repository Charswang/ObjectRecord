package leetcode;

/**
 * 2022-4-30
 * 每日一题
 */
public class P908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 使用Math.max((max - k) - (min + k),0)，而不是(max - k) - (min + k)的原因如下：
        // 如果小于0的话，就说明max - k)和(min + k)这两个值肯定能相等，这样最小的差就是0了。
        // 因为两者之差最小只能是0，不能是负数
        return Math.max((max - k) - (min + k),0);
    }
}
