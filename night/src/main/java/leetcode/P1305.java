package leetcode;

import java.util.*;

/**
 * 2022-5-1
 * 每日一题
 */
public class P1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // 中序遍历得到的结果是二叉搜索树的顺序搜索
        List<Integer> l1 = inorderTraversal(root1);
        List<Integer> l2 = inorderTraversal(root2);
        for (Integer integer : l2) {
            l1.add(integer);
        }
        Collections.sort(l1);
        return l1;
    }
    // 中序遍历
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
}
