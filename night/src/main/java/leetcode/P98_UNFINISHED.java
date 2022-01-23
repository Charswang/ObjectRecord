package leetcode;

/**
 * 2021-9-15
 * 验证二叉树
 *
 * 1、判断中序遍历是否为升序排列
 * 2、设置最小值，最大值，每次遍历的时候把根节点的值分别当作最小值和最大值；
 */
public class P98_UNFINISHED {
    public static void main(String[] args) {

    }
    public static boolean isValidBST(TreeNode root) {
        // 使用Long的原因是用例中会有Integer.MAX_VALUE.会把原来该是true的变为false；
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean valid(TreeNode root,long min,long max){
        if (root==null){
            return true;
        }
        // root.val<=min这个判断是避免右子树的左节点出现小于根节点的元素；
        // root.val>=max这个判断是避免左子树的右节点出现大于根节点的元素。
        if (root.val<min || root.val>max){
            return false;
        }
        return valid(root.left,min,root.val) && valid(root.right,root.val,max);
    }
}
