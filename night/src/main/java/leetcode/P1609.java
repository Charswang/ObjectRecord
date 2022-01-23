package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2021-12-25
 * 每日一题
 */
public class P1609 {
    public boolean isEvenOddTree(TreeNode root) {
        // Deque是双向队列，可以直接访问队列中的最后一个元素；虽然很这里用不用都一样，因为没有用到取最后一个元素的时候；
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int peek = 0;
        while (!q.isEmpty()) {
//            Queue<TreeNode> p = new LinkedList<>();
            Deque<TreeNode> p = new LinkedList<>();
            int a = Integer.MAX_VALUE;
            int b = Integer.MIN_VALUE;
            while (!q.isEmpty()){
                TreeNode poll = q.poll();
                if (peek%2==0){
                    if (poll.val%2!=0 && poll.val>b){
                        if (poll.left!=null){
                            p.add(poll.left);
                        }
                        if (poll.right!=null){
                            p.add(poll.right);
                        }
                        b = poll.val;
                    }else{
                        return false;
                    }
                }else {
                    if (poll.val%2==0 && poll.val<a) {
                        if (poll.left != null) {
                            p.add(poll.left);
                        }
                        if (poll.right != null) {
                            p.add(poll.right);
                        }
                        a = poll.val;
                    }else{
                        return false;
                    }
                }
            }
            q=p;
            peek++;
        }
        return true;
    }
}
