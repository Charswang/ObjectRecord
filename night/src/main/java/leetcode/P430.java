package leetcode;

/**
 * 2021-9-24
 * 每日一题 430. 扁平化多级双向链表
 */
public class P430 {
    /*public NodeChildren flatten(NodeChildren head) {
        if (head==null){
            return head;
        }
        NodeChildren t = head;
        while(t!=null){
            NodeChildren temp = t.next;
            if (t.child!=null){
                NodeChildren p = flatten(t.child);
                t.next = p;
                p.prev=t;
                NodeChildren q = p;
                while (q!=null && q.next!=null){
                    q = q.next;
                }
                q.next = temp;
                // 注意temp为空，但是t下面还有子链表的时候；例如1 null 2 null 3 null；
                // temp=null的时候。temp是没有prev的
                if(temp!=null){
                    temp.prev=q;
                }

            }
            t.child=null;
            t=temp;
        }
        return head;
    }*/
}
class Node {
    public int val;
    public NodeChildren prev;
    public NodeChildren next;
    public NodeChildren child;
};
