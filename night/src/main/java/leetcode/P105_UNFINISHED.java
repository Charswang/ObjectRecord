package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021-9-12
 */
public class P105_UNFINISHED {
    private Map<Integer,Integer> map;
    public static void main(String[] args) {

    }
    public TreeNode MyBuildTree(int[] preorder,int[] inorder,int pre_left,int pre_right,int in_left,int in_right){
        if (pre_left>pre_right){
            return null;
        }
        int int_root = map.get(preorder[pre_left]);
        int left_num = int_root-in_left;
        TreeNode root = new TreeNode(preorder[pre_left]);
        TreeNode root_left = MyBuildTree(preorder, inorder, pre_left + 1, pre_left + left_num, in_left, int_root - 1);
        TreeNode root_right = MyBuildTree(preorder, inorder, pre_left + left_num + 1, pre_right, int_root + 1, in_right);
        root.left = root_left;
        root.right = root_right;
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i=0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = MyBuildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        return root;
    }
}
