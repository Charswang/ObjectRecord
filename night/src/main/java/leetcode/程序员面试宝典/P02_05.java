package leetcode.程序员面试宝典;


/**
 * 2002-7-17
 * 链表求和
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class P02_05 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p = new ListNode(-1);
        ListNode q = p;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int num = num1 + num2 + carry;
            carry = num / 10;
            ListNode node = new ListNode(num % 10);
            p.next = node;
            p = p.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            p.next = node;
        }
        return q.next;
    }
}
