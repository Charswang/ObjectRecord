package leetcode;

/**
 * 2021-12-6
 */
public class P494 {
    int x = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return x;
    }
    public void dfs(int[] nums,int target,int num,int sum){
        if (num == nums.length){
            if (sum==target){
                x++;
            }
            return;
        }
        dfs(nums, target, num + 1, sum + nums[num]);
        dfs(nums, target, num + 1, sum - nums[num]);
    }
}
