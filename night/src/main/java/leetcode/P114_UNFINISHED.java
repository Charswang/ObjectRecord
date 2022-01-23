package leetcode;

/**
 * 2021-9-17
 */
public class P114_UNFINISHED {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null){
            root = root.right;
        }
        root.right = temp;
    }
}
