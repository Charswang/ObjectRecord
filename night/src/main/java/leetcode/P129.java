package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-10-18
 */
public class P129 {
    List<String> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root,"");
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
    public void dfs(TreeNode root,String s){
        if (root==null){
            list.add(s);
            return;
        }
        dfs(root.left,s+root.val);
        dfs(root.right,s+root.val);
    }
}
