package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2021-9-10
 */
public class P107 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedBlockingQueue<TreeNode> qe = new LinkedBlockingQueue<>();
        qe.add(root);
        while (!qe.isEmpty()) {
            int size = qe.size();
            ArrayList<Integer> integers = new ArrayList<>();
            while (size > 0) {
                TreeNode poll = qe.poll();
                integers.add(poll.val);
                if (poll.left!=null){
                    qe.add(poll.left);
                }
                if (poll.right!=null){
                    qe.add(poll.right);
                }
                size--;
            }
            res.add(0,integers);
        }
        return res;
    }
}
