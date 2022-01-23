package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2021-10-14
 */
public class P116 {
    public P116Node connect(P116Node root){
//        LinkedBlockingQueue<P116Node> que = new LinkedBlockingQueue<P116Node>();
        Queue<P116Node> que = new LinkedList<P116Node>();
        que.add(root);
        int i = 0;
        while (root!=null && !que.isEmpty()){
            for (int j = 0;j < Math.pow(2,i);j++){
                P116Node poll = que.poll();
                if (poll.left!=null){
                    que.add(poll.left);
                }
                if (poll.right!=null){
                    que.add(poll.right);
                }
                /*if (que.isEmpty()){
                    poll.next=null;
                    break;
                }*/
                if (j==Math.pow(2,i)-1){
                    poll.next=null;
                }else{
                    poll.next = que.peek();
                }
            }
            i++;
        }
        return root;
    }
}
class P116Node {
    public int val;
    public P116Node left;
    public P116Node right;
    public P116Node next;

    public P116Node() {}

    public P116Node(int _val) {
        val = _val;
    }

    public P116Node(int _val, P116Node _left, P116Node _right, P116Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};