package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021-9-13
 */
public class P106 {
    private Map<Integer,Integer> map;
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return myBuildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode myBuildTree(int[] inorder, int[] postorder,int in_left,int in_right,int post_left,int post_right){
        if (post_left>post_right){
            return null;
        }
        int in_root = map.get(postorder[post_right]);
        int left_num = in_root - in_left;
        TreeNode root = new TreeNode(postorder[post_right]);
        TreeNode root_left = myBuildTree(inorder, postorder, in_left, in_root-1, post_left, post_left+left_num-1);
        TreeNode root_right = myBuildTree(inorder, postorder, in_root+1, in_right, post_left+left_num, post_right-1);
        root.left = root_left;
        root.right = root_right;
        return root;
    }
}
