package leetcode;

/**
 * 2021-9-14
 * <p>
 * 根据有序链表构建平衡二叉树
 */
public class P109_UN {
    public static void main(String[] args) {

    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        // 剪枝，没有的话会超时
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 快慢指针找到中间的节点
        ListNode slow = head, fast = head, pre = head;
        while (fast!=null&&fast.next!=null){
            pre = slow; // 关键的一步，要一直让pre在中间节点的前一个，这样才能使左子树对应的链表最后一个节点；
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
