package leetcode;

import java.util.ArrayList;

public class P234 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next=b;
        boolean palindrome = isPalindrome(a);
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
        }
        int size = list.size();
        int mid = size / 2;
        for (int i = 0;i < mid;i++){
            if (list.get(i)!=list.get(size-1-i)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome1(ListNode head) {
        StringBuffer sb = new StringBuffer("");
        while (head!=null){
            sb.append(head.val);
            head = head.next;
        }
        String s = sb.toString();
        /**
         * sb.reverse之后，sb本身也会反转的，其实reverse=sb.reverse()和sb是一个。。。
         */
        StringBuffer reverse = sb.reverse();
        String s1 = reverse.toString();
        System.out.println(s);
        System.out.println(s1);
        if (s.equals(s1)){
            return true;
        }
        return false;
    }
}
