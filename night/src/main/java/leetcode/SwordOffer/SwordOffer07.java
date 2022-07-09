package leetcode.SwordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022-7-6
 * 重建二叉树
 * <p>
 * 由前序和中序遍历重建二叉树
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SwordOffer07 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart>preEnd){
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[preStart]);
        int leftIndex = map.get(preorder[preStart]);
        int leftNum = leftIndex - inStart;
        TreeNode leftNode = dfs(preorder,inorder,preStart+1,preStart+leftNum,inStart,leftIndex-1);
        TreeNode rightNode = dfs(preorder,inorder,preStart+leftNum+1,preEnd,leftIndex+1,inEnd);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }
}
