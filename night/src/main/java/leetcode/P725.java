package leetcode;

import java.util.ArrayList;

/**
 * 2021-9-22
 * 每日一题
 */
public class P725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode[] res = new ListNode[k];
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int avg_num = list.size() / k;
        int mol_num = list.size() % k;
        if (avg_num==0){
            ListNode a = head;
            for (int i = 0;i < mol_num;i++){
                res[i] = head;
                ListNode tem = head.next;
                head.next = null;
                head = tem;
            }
            return res;
        }
        ListNode q = head;
        for (int i = 0; i < k; i++) {
            ListNode t = null;
            for (int j = 0;j < avg_num;j++){
                if (j ==0){
                    t = q;
                }else {
                    t = t.next;
                }
            }
            if (i<mol_num){
                t = t.next;
            }
            ListNode temp = t==null?null:t.next;
            t.next = null;
            res[i] = q;
            q = temp;
        }
        return res;
    }
}
