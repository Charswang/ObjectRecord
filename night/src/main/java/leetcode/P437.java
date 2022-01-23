package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2021-9-28
 * 每日一题
 */
public class P437 {
    private int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while(root!=null && !treeNodes.isEmpty() ){
            TreeNode poll = treeNodes.poll();
            dfs(poll,targetSum,0);
            if (poll.left!=null){
                treeNodes.offer(poll.left);
            }
            if (poll.right!=null){
                treeNodes.offer(poll.right);
            }
        }
        return res;
    }

    public void dfs(TreeNode root, int targetSum, int partSum) {
        if (root == null) {
            return;
        }
        int root_val = root.val;
        if ((partSum + root_val) == targetSum) {
            res++;
            // System.out.println(root.val);
            // 不加return 是因为从根节点到某一个叶子节点中同一条路径上可能会出现多个
            // 比如【1,-2,-3,1,3,-2,null,-1】 target=-1
            // return;
        }

        // if ((partSum + root_val) < targetSum) {
        //     dfs(root.left, targetSum, partSum + root_val);
        //     dfs(root.right, targetSum, partSum + root_val);
        // }

        // 不加if是因为避免出现-2、-3；target为-5的时候
        dfs(root.left, targetSum, partSum + root_val);
        dfs(root.right, targetSum, partSum + root_val);
        return;
    }
}
