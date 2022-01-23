package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2021-10-20
 */
public class P199 {
    // 层序遍历，找到每层的最后一个
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        res.add(root.val);
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            Queue<TreeNode> temp = new LinkedList<>();
            TreeNode node = null;
            while(!que.isEmpty()){
                TreeNode poll = que.poll();
                if (poll.left!=null){
                    temp.add(poll.left);
                }
                if (poll.right!=null){
                    temp.add(poll.right);
                }
                node = poll;
            }
            res.add(node.val);
            que=temp;
        }
        return res;
    }
}
