package leetcode.competition.easy;

/**
 * 2022-4-17
 * <p>
 * 6060. 找到最接近 0 的数字
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
 */
public class P6060 {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            int abs = Math.abs(num);
            if (min > abs) {
                min = abs;
                res = num;
            } else if (min == abs) {
                res = Math.max(num, res);
            }
        }
        return res;
    }
}
