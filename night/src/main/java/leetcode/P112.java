package leetcode;

public class P112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        return pathSum(root,0,targetSum);
    }
    public boolean pathSum(TreeNode root,int temp_sum,int targetSum){
        if (root.left==null && root.right==null && (temp_sum+root.val)==targetSum){
            return true;
        }else if (root==null){
            return false;
        }
        temp_sum = temp_sum+root.val;
        boolean b_left = pathSum(root.left, temp_sum, targetSum);
        boolean b_right = pathSum(root.right, temp_sum, targetSum);
        if (b_left || b_right){
            return true;
        }else{
            return false;
        }
    }
}
