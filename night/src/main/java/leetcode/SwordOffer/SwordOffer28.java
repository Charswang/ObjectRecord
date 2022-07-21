package leetcode.SwordOffer;

/**
 * 2022-7-21
 */
public class SwordOffer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return check(root.left,root.right);
    }
    public boolean check(TreeNode l,TreeNode r){
        if (l==null && r==null){
            return true;
        }
        if (l==null || r==null){
            return false;
        }
        if (l.val!=r.val){
            return false;
        }
        boolean b1 = check(l.left, r.right);
        boolean b2 = check(l.right, r.left);
        if (b1 && b2){
            return true;
        }
        return false;
    }
}
