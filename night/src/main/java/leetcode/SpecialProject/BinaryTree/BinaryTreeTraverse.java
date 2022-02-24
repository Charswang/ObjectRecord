package leetcode.SpecialProject.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-2-24 ~ 2022-2-xx
 * 记录一下，二叉树的遍历相关的工作。(●'◡'●)
 */
public class BinaryTreeTraverse {
    /**
     * 前序遍历
     * 要分：1、递归遍历；2、非递归遍历的方式；
     * @param root
     * @return
     */
    List<Integer> res1 = new ArrayList<Integer>();
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        dfsRecursive(root);
        return res1;
    }
    public void dfsRecursive(TreeNode root){
        if (root==null){
            return;
        }
        res1.add(root.val);
        dfsRecursive(root.left);
        dfsRecursive(root.right);
    }
    // 重要的非递归遍历
    // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res2 = new ArrayList<>();

        return res2;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}