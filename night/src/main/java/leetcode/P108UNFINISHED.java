package leetcode;

/**
 * 2021-9-14
 * 构建平衡二叉树
 */
public class P108UNFINISHED {
    public static void main(String[] args) {

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0){
            return null;
        }
        return dfs(nums,0,nums.length-1);
    }
    public static TreeNode dfs(int[] nums,int left,int right){
        if (left > right){
            return null;
        }
        int middle = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = dfs(nums,left,middle-1);
        root.right = dfs(nums, middle+1, right);
        return root;
    }
}
