package leetcode;

/**
 * 2021-11-29
 */
public class P543_UN {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // 左子树最大深度+右子树虽大深度
        if (root==null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if(root.left!=null){
            left = dfs(root.left)+1;
        }
        if(root.right!=null){
            right = dfs(root.right)+1;
        }
        int res = left + right;
        int a = diameterOfBinaryTree(root.left);
        int b = diameterOfBinaryTree(root.right);
        // max = max>res?max:res;
        return Math.max(res,Math.max(a,b));
    }
    public int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int i=0;
        int i1=0;
        if(root.left!=null){
            i = dfs(root.left)+1;
        }
        if(root.right!=null){
            i1 = dfs(root.right)+1;
        }
        return Math.max(i,i1);
    }
}
