package leetcode;

/**
 * 2021-11-2
 * 每日一题
 */
public class P237_un {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
