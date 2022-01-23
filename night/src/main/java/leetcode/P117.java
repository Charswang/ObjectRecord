package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2021-10-14
 */
public class P117 {
    public P116Node connect(P116Node root) {
        Queue<P116Node> que = new LinkedList<>();
        que.add(root);
        int temp = 1;
        while(root!=null && !que.isEmpty()){
            int count = 0;
            for (int i = 0;i < temp;i++){
                P116Node poll = que.poll();
                if (poll.left!=null){
                    que.add(poll.left);
                    count++;
                }
                if (poll.right!=null){
                    que.add(poll.right);
                    count++;
                }
                if (i==(temp-1)){
                    poll.next=null;
                }else {
                    poll.next = que.peek();
                }
            }
            temp = count;
        }
        return root;
    }
}
