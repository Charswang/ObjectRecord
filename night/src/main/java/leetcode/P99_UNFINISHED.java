package leetcode;

/**
 * 2021-9-22
 * 不是自己的
 */
public class P99_UNFINISHED {
    private TreeNode a,b,temp;
    public void recoverTree(TreeNode root) {
        middleSeek(root);
        int c = a.val;
        a.val = b.val;
        b.val = c;
    }
    public void middleSeek(TreeNode root){
        if (root==null){
            return;
        }
        middleSeek(root.left);
        if (temp!=null && temp.val>root.val){
            if (a==null){
                a = temp;
            }
            b = root;
        }
        temp = root;
        middleSeek(root.right);
    }
}
