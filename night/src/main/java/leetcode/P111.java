package leetcode;

/**
 * 2021-9-16
 * 最小深度
 */
public class P111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left!=0 && right!=0) {
            return Math.min(left, right) + 1;
        }else if(left==0){
            return right+1;
        }else{
            return left+1;
        }
    }
}
