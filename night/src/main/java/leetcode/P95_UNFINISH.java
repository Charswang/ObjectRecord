package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-9-6
 * 二叉搜索树的构建
 *
 * 不同的二叉搜索树
 *
 * 2021-9-7
 */
public class P95_UNFINISH {
    public static void main(String[] args) {

    }
    public static List<TreeNode> generateTrees(int n) {
        if (n<1){
            return new ArrayList<TreeNode>();
        }
        return helper(1,n);
    }
    public static List<TreeNode> helper(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if (start>end){
            res.add(null);
            return res;
        }
        for (int i = start;i<=end;i++){
            // 不可以放在这里，为什么呢？因为如果放在这里，添加的只会是同一个temp，而不会是各种不同的temp
//            TreeNode temp = new TreeNode(i);
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (TreeNode treeNode : left) {
                for (TreeNode node : right) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = treeNode;
                    temp.right = node;
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
