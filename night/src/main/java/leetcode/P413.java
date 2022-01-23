package leetcode;

public class P413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2 || nums==null) {
            return 0;
        }
        int add = 0;
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                res += ++add;
            } else {
                add = 0;
            }
        }
        return res;
    }
}
