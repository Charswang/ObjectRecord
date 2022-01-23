package leetcode;

/**
 * 2021-9-2
 */
public class Offer22 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;
        ListNode kthFromEnd = getKthFromEnd(listNode1, 3);
        System.out.println(kthFromEnd.val);
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        for (int i = 1;i < k;i++){
            pre = pre.next;
        }
        while(pre.next!=null){
            head = head.next;
            pre = pre.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
