package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2021-9-12
 */
public class P103 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedBlockingQueue<TreeNode> treeNodes = new LinkedBlockingQueue<TreeNode>();
        treeNodes.add(root);
        boolean flag = true; // true:正向；false:反向
        while (!treeNodes.isEmpty()) {
            ArrayList<Integer> lists = new ArrayList<>();
            int size = treeNodes.size();
            while (size > 0) {
                TreeNode poll = treeNodes.poll();
                int val = poll.val;
                if (flag == true) {
                    lists.add(0, val);
                } else {
                    lists.add(val);
                }
                if (poll.right != null) {
                    treeNodes.offer(poll.right);
                }
                if (poll.left != null) {
                    treeNodes.offer(poll.left);
                }
                size--;
            }
            res.add(lists);
            flag = flag == true ? false : true;
        }
        return res;
    }
}
