package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P230 {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历
        Collections.sort(list);
        return list.get(k-1);
    }
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
