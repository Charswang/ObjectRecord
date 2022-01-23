package leetcode;

/**
 * 2021-11-28
 */
public class P617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null){
            return null;
        }
        TreeNode t = new TreeNode();
        if (root1!=null){
            if (root2!=null){
                t.val = root1.val + root2.val;
                t.left = mergeTrees(root1.left,root2.left);
                t.right = mergeTrees(root1.right,root2.right);
            }else {
                t.val = root1.val;
                t.left = mergeTrees(root1.left,null);
                t.right = mergeTrees(root1.right,null);
            }
        }else{
            t.val = root2.val;
            t.left = mergeTrees(null,root2.left);
            t.right = mergeTrees(null,root2.right);
        }
        return t;
    }
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1!=null && root2!=null){
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left,root2.left);
            root1.right = mergeTrees(root1.right,root2.right);
            return root1;
        }
        if (root1!=null){
            return root1;
        }
        return root2;

    }
}
