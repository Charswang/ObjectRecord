package leetcode;

import java.util.Stack;

/**
 * 2021-10-19
 */
public class P173_again {
    Stack<TreeNode> stack = new Stack<>();
    public P173_again(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        int res = pop.val;
        pop = pop.right;
        while(pop!=null){
            stack.push(pop);
            pop = pop.left;
        }
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
