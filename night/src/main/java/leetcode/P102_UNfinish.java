package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2021-9-10
 * 层序遍历二叉树
 */
public class P102_UNfinish {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root==null){
            return null;
        }
        LinkedBlockingQueue<TreeNode> qe = new LinkedBlockingQueue<>();
        qe.add(root);

        while (!qe.isEmpty()){
            int size = qe.size();
            ArrayList<Integer> integers = new ArrayList<>();
            while(size > 0){
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
            res.add(integers);
        }
        return res;
    }
}
