package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回一个数组中的所有子集
 */
public class P78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        /*result.add(item);
        for (int i = 0;i < nums.length;i++){
            int size = result.size();
            for (int j = 0;j<size;j++){
                List<Integer> integers = result.get(j);
                ArrayList<Integer> integers1 = new ArrayList<Integer>(integers);
                integers1.add(nums[i]);
                result.add(integers1);
            }
        }*/
        dfs(0,nums,result,item);
        return result;
    }

    public void dfs(int index,int[] nums,List<List<Integer>> result,List<Integer> item) {
        if (index==nums.length){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        // 将第i为加上
        item.add(nums[index]);
        dfs(index+1,nums,result,item);
        // 不加上第i位
        item.remove(item.size()-1);
        dfs(index+1,nums,result,item);
    }
}
