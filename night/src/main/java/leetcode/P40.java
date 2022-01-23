package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P40 {
    private static List<List<Integer>> result =  new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        Arrays.sort(candidates);
        int target = 8;
//        int[] candidates = {2,5,2,1,2};
//        int target = 5;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    public  static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list_temp = new ArrayList<Integer>();
        dfs(candidates,target,list_temp,0,0);
        return result;
    }
    public static void dfs(int[] candidates,int target,List<Integer> list_temp,int sum,int begin){
        /*if(sum > target){
            return;
        }*/
        if(sum == target){
            ArrayList<Integer> integers = new ArrayList<Integer>(list_temp);
            Collections.sort(integers);
            if (!result.contains(integers)){
                result.add(integers);
            }
//            result.add(new ArrayList<Integer>(list_temp));
            return;
        }
        for(int i = begin;i < candidates.length;i++){
            // 有效大剪枝
            if (sum + candidates[i] > target){
                break;
            }
            // 有效小剪枝
            // 需要好好理解??因为含有重复数字的所有情况都在第一个重复数字出现时就列举完了；
            // 所以不再需要，再拿重复元素来列举了。
            // 所以这里这届进行筛选。
            if(i>begin&&candidates[i]==candidates[i-1]){
                continue;
            }
            list_temp.add(candidates[i]);
            dfs(candidates,target,list_temp,sum+candidates[i],i+1);
            list_temp.remove(list_temp.size()-1);
        }
    }
}
