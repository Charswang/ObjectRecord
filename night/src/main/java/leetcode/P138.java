package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2022-5-1
 *
 * 哈希表--HashMap模拟节点a对应的深拷贝a'节点
 */
public class P138 {
    public P138Node copyRandomList(P138Node head) {
        if(head==null){
            return null;
        }
        P138Node p = head;
        P138Node h1 = new P138Node(head.val);
        HashMap<P138Node,P138Node> map = new HashMap<>();
        map.put(head,h1);
        P138Node res = h1;
        while (p.next!=null){
            h1.next = new P138Node(p.next.val);
            map.put(p.next,h1.next);
            h1 = h1.next;
            p = p.next;
        }

        while (head!=null){
            P138Node random = head.random;
            P138Node h = map.get(head);
            P138Node m = map.get(random);
            h.random = m;
            head = head.next;
        }
        return res;
    }

}
class P138Node {
    int val;
    P138Node next;
    P138Node random;

    public P138Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
