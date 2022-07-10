package leetcode.SwordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-7-10
 */
public class SwordOffer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs34(root,target,res,temp,0);
        return res;
    }

    public void dfs34(TreeNode root, int target, List<List<Integer>> res, List<Integer> temp,int partSum) {
        if (root==null){
            return;
        }else if (root.left==null && root.right==null && (root.val+partSum)==target){
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            // 要把这里记住！！！！！！！
            temp.remove(temp.size()-1);
            return;
        }
        partSum += root.val;
        temp.add(root.val);
        dfs34(root.left,target,res,temp,partSum);
        dfs34(root.right,target,res,temp,partSum);
        temp.remove(temp.size()-1);
    }
}
