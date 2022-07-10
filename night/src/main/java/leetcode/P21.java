package leetcode;

/**
 * 2022-2-22
 * <p>
 * 2022-7-9
 */
public class P21 {

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p = null;
        ListNode q = null;
        if (l1.val > l2.val) {
            q = p = l2;
            l2 = l2.next;
        } else {
            q = p = l1;
            l1 = l1.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            } else {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return q;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p = new ListNode(0);
        ListNode q = p;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            } else {
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }
        }
        p.next = list1 == null ? list2 : list1;
        return q.next;
    }
}
