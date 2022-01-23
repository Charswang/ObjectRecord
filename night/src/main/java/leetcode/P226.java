package leetcode;

/**
 * 201-10-26
 * 翻转二叉树
 */
public class P226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        /**
         * 加这个是错误的
         */
        /*if (root.left==null || root.right==null){
            return root;
        }*/
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
