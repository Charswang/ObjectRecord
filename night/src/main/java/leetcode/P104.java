package leetcode;

/**
 * 2021-9-10
 */
public class P104 {
    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
