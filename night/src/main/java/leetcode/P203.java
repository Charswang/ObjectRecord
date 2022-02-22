package leetcode;

/**
 * 2022-2-22
 */
public class P203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null && head.val==val){
            head=head.next;
        }
        if (head==null){
            return null;
        }
        ListNode p = head;
        while (head.next!=null){
            if (head.next.val==val){
                head.next=head.next.next;
            }else {
                head=head.next;
            }
        }
        return p;
    }
}
