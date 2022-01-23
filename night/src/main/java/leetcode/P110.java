package leetcode;

/**
 * 2021-9-14
 */
public class P110 {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int a = deep(root.left);
        int b = deep(root.right);
        if (Math.abs(a-b)>1){
            return false;
        }
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        if (l==false||r==false){
            return false;
        }
        return true;
    }
    public int deep(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = deep(root.left)+1;
        int right = deep(root.right)+1;
        return Math.max(left,right);
    }
}
