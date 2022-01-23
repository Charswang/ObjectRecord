package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-9-17
 */
public class p113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> item = new ArrayList<>();
        path(root,targetSum,res,item,0);
        return res;
    }
    public void path(TreeNode root,int targetSum,List<List<Integer>> res,ArrayList<Integer> item,int partSum){
        if (root==null){
            return;
        }else if (root.left==null&&root.right==null&&(partSum+root.val)==targetSum){
            item.add(root.val);
            res.add(new ArrayList<>(item));
            //!!!!!!!
            item.remove(item.size()-1); // 做这个题的时候，忘记在这里再删除一次了；
            return;
        }
        partSum += root.val;
        item.add(root.val);
        path(root.left, targetSum, res, item, partSum);
        path(root.right, targetSum, res, item, partSum);
        // 这一步很重要！！！
        item.remove(item.size()-1);
    }
}
