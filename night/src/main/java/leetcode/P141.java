package leetcode;

/**
 * 2021-10-18
 */
public class P141 {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针判断链表十分有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (p!=null && q!=null){
            p = p.next;
            if (q.next!=null){
                q = q.next.next;
            }else{
                return false;
            }
            if (p==q){
                return true;
            }
        }
        return false;
    }
}
