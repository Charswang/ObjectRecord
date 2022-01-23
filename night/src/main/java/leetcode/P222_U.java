package leetcode;

/**
 * 2021-10-25
 */
public class P222_U {
    /**
     * 利用完全二叉树的性质
     * @param root
     * @return
     */
    public int countNode(TreeNode root){
        if (root==null){
            return 0;
        }
        int left_level = countLevel(root.left);
        int right_level = countLevel(root.right);
        if (left_level==right_level){
            return (1<<left_level) + countNode(root.right);
        }else{
            return (1<<right_level) + countNode(root.left);
        }
    }
    public int countLevel(TreeNode root){
        int level = 0;
        while (root!=null){
            level++;
            root = root.left;
        }
        return level;
    }

    /**
     * 简单的普通二叉树递归获取节点数量，没有用到完全二叉树的性质；
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        if(root==null){
            return 0;
        }
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
}
