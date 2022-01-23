package leetcode;

public class P5927_UNFINISHED {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode p = head;
        int group = 1;
        while (head!=null){
            if (head.next==null){
                break;
            }
            group++;
            if (group%2==0){
                ListNode q = head;//前面奇数组的最后一个节点
                boolean flag = true;//判断改组是否有偶数个节点
                for (int i = 0;i < group;i++){
                    head=head.next;
                    if (head==null){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    ListNode reverse = reverse(q.next, group);
                    q.next=head;
                    reverse.next = head.next;
                    head = reverse;
                }
            }else{
                ListNode q = head;
                int i = 0;
                while(head.next!=null && i<group){
                    head = head.next;
                    i++;
                }
                if (head==null && i%2==0){
                    ListNode reverse = reverse(q.next, i);
                    q.next = head;
                    reverse.next=head.next;
                }
            }
        }
        return p;
    }
    public ListNode reverse(ListNode node,int group){
        ListNode head = node;
        node = head.next;
        ListNode p = head;
        int i = 0;
        while(node!=null && i<group-1){
            ListNode a = node;
            node = a.next;
            a.next=p;
            p=a;
            i++;
        }
        return head;//返回反转之后的第一个节点
    }
}
