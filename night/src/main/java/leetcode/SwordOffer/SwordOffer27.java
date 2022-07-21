package leetcode.SwordOffer;

/**
 * 2022-7-21
 */
public class SwordOffer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = mirrorTree(r);
        root.right = mirrorTree(l);
        return root;
    }
}
