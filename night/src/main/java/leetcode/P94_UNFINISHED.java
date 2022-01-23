package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2021-9-6
 */
public class P94_UNFINISHED {
    public static void main(String[] args) {

    }
    // 中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        // 递归
        List<Integer> res = new ArrayList<>();
        /*digui(root,res);
        return res;*/
        // 非递归
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp!=null || !stack.isEmpty()){
            if (temp!=null){
                stack.push(temp);
                temp = temp.left;
            }else{
                TreeNode pop = stack.pop();
                res.add(pop.val);
                temp = temp.right;
            }
        }
        return res;
    }
    public static void digui(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }
        digui(root.left,res);
        res.add(root.val);
        digui(root.right,res);
    }
}

class TreeNode1 {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
