package leetcode.SpecialProject.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2022-2-24 ~ 2022-2-xx
 * 记录一下，二叉树的遍历相关的工作。(●'◡'●)
 */
public class BinaryTreeTraverse {
    /**
     * 前序遍历
     * 要分：1、递归遍历；2、非递归遍历的方式；
     *
     * @param root
     * @return
     */
    // 1、递归遍历
    List<Integer> res1 = new ArrayList<Integer>();

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        dfsRecursive(root);
        return res1;
    }

    public void dfsRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        res1.add(root.val);
        dfsRecursive(root.left);
        dfsRecursive(root.right);
    }

    // 2、重要的非递归遍历  --  栈
    // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res2 = new ArrayList<>();
        if (root == null) {
            return res2;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res2.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res2;
    }

    /**
     * 中序遍历
     * 要分：1、递归遍历；2、非递归遍历的方式；
     *
     * @param root
     * @return
     */
    // 1、递归遍历
    List<Integer> res3 = new ArrayList<>();

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        dfsinorderTraversal(root);
        return res3;
    }

    public void dfsinorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsinorderTraversal(root.left);
        res3.add(root.val);
        dfsinorderTraversal(root.right);
    }

    // 2、非递归遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res4 = new ArrayList<>();
//        if (root == null) {
//            return res4;
//        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            res4.add(pop.val);
            if (pop.right != null) {
                cur = pop.right;
                // stack.push(cur);  这个不能加的，push操作都是在while里面进行操作的。
            }
        }
        return res4;
    }

    /**
     * 后序遍历
     * 要分：1、递归遍历；2、非递归遍历的方式；
     * @param root
     * @return
     */
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}