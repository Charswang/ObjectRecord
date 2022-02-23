package leetcode;

/**
 * 2022-2-23
 */
public class P83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode p = head;
        while (head.next!=null){
            if (head.next.val==head.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return p;
    }
}
