package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-1-9
 * dfs
 */
public class P131_U {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<String>());
        return res;
    }
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public void dfs(String s,int start,List<String> list){
        if (start==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start+1;i <= s.length();i++){
            String substring = s.substring(start, i);
            if (isPalindrome(substring)){
                list.add(substring);
                dfs(s,i,list);
                list.remove(list.size()-1);
            }
        }
    }
}
