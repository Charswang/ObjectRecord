package leetcode;

import java.util.Stack;

/**
 * 2021-11-7
 * 反转链表
 */
public class P206 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = null;

        System.out.println(reverseList(a).val);

    }
    // 1 2 3 4 5
    public ListNode reverseList2(ListNode head) {
        ListNode p = null;
        while (head!=null){
            ListNode q = head.next;
            head.next=p;
            p = head;
            head = q;
        }
        return p;
    }
    public static ListNode reverseList(ListNode head) {
        // 12345 -- 54321
        if (head==null){
            return null;
        }
        //p是前面的，q是后面的
        ListNode p = null;
        while(head.next!=null){
            ListNode q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        head.next = p;
        return head;
    }
    public ListNode reverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()){
            return null;
        }
        ListNode res = stack.pop();
        ListNode r = res;
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            r.next = pop;
            r = pop;
        }
        r.next = null;
        return res;
    }
}
