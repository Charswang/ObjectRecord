package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P101 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3,null,null);
        TreeNode treeNode1 = new TreeNode(4,null,null);
        TreeNode treeNode2 = new TreeNode(4,null,null);
        TreeNode treeNode3 = new TreeNode(3,null,null);
        TreeNode treeNode4 = new TreeNode(2,treeNode1,treeNode);
        TreeNode treeNode5 = new TreeNode(2,treeNode3,treeNode2);
        TreeNode treeNode6 = new TreeNode(1,treeNode5,treeNode4);
        System.out.println(isSymmetric(treeNode6, treeNode6));
    }

    public static boolean isSymmetric(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
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
