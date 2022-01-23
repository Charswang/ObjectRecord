package leetcode;

/**
 * 2021-11-18
 * 每日一题
 */
public class P563 {
    int sum = 0;
    public int findTilt(TreeNode root) {
        findSum(root);
        return sum;
    }
    public int findSum(TreeNode root){
        if (root.left==null && root.right==null){
            return root.val;
        }
        int left = 0;
        int right = 0;
        if (root.left!=null){
            left = root.left.val;
        }
        if (root.right!=null){
            right = root.right.val;
        }
        sum += Math.abs(left-right);
        return left + right;
    }
}
