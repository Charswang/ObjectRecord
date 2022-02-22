package leetcode;

/**
 * 2022-2-22
 */
public class P21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode p = new ListNode(0);
        ListNode q = p;
        while(list1!=null && list2!=null){
            if (list1.val>list2.val){
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }else{
                p.next=list1;
                p = p.next;
                list1 = list1.next;
            }
        }
        p.next=list1==null?list2:list1;
        return q.next;
    }
}
