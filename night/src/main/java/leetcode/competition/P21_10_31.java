package leetcode.competition;


import java.util.ArrayList;
import java.util.List;

public class P21_10_31 {
    public int smallestEqual(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            if (i%10==nums[i]){
                return i;
            }
        }
        return -1;
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int start = head.val;
        int count = 0;
        while(head.next!=null){
            ListNode end_node = head.next;
            int mid = head.val;
            int end = end_node.val;
            if (mid>start && mid>end){
                list.add(count);
            }
            if (mid<start && mid<end){
                list.add(count);
            }
            start = mid;
            head = head.next;
            count++;
        }
        int[] res = new int[2];
        if (list.size()<2){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        res[1] = list.get(list.size()-1)-list.get(0);
        int min = res[1];
        for (int i = 0;i < list.size()-1;i++){
            if ((list.get(i+1)-list.get(i))<min){
                min = list.get(i+1)-list.get(i);
            }
        }
        res[0] = min;

        return res;
    }
    List<Integer> list = new ArrayList<>();
    public int minimumOperations(int[] nums, int start, int goal) {
        dfs(nums,start,start,goal,0);
        if (list.size()==0){
            return -1;
        }
        int min = list.get(0);
        for (Integer integer : list) {
            if (integer<min){
                min = integer;
            }
        }
        return min;
    }
    public void dfs(int[] nums,int start,int x,int goal,int step){
        if (start == goal){
            list.add(step);
            return;
        }
        if (start<0 || start>1000){
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if ((x+nums[i])!=start){
                dfs(nums,start,x+nums[i],goal,step+1);
            }
            if ((x-nums[i])!=start){
                dfs(nums,start,x-nums[i],goal,step+1);
            }
            if ((x^nums[i])!=start){
                dfs(nums,start,x^nums[i],goal,step+1);
            }
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
