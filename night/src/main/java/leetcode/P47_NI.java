package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2021-8-30
 */
public class P47_NI {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> integers = new ArrayList<Integer>();
        HashSet<List<Integer>> lists = new HashSet<List<Integer>>();
        int[] visited = new int[nums.length];
        dfs(lists,integers,nums,visited);
        List<List<Integer>> lists1 = new ArrayList<List<Integer>>();
        for (List<Integer> list : lists) {
            lists1.add(list);
        }
        return lists1;
    }
    public static void dfs(HashSet<List<Integer>> res, List<Integer> item, int[] nums, int[] visited){
        if (item.size()==nums.length){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            /*if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }*/
            // !vis[i - 1],如果有重复，时刻保证在前面的访问过之后才能在访问后面的，否则可能就会重复
            if (visited[i]==0){
                visited[i]=1;
                item.add(nums[i]);
                dfs(res, item, nums, visited);
                visited[i]=0;
                item.remove(item.size()-1);
            }
        }
    }
}
