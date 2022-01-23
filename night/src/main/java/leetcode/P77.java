package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        dfs(result,item,n,k,0,1);
        return result;
    }
    public void dfs(List<List<Integer>> result,List<Integer> item,int n,int k,int num,int begin){
        if (k<num){
            return;
        }
        if (item.size()==k){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = begin;i <= n;i++){
            item.add(i);
            dfs(result, item, n, k, num+1, i+1);
            item.remove(item.size()-1);
        }
    }
}
