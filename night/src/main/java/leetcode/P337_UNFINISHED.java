package leetcode;

import java.util.*;

/**
 * 2021-12-12
 */
public class P337_UNFINISHED {
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root==null){
            return 0;
        }
        /**
         * 为什么会需要这个？？还会出现重复计算的值吗？
         * 因为下面还有个不偷取当前节点的操作，肯定会出现重复计算的值的；
         */
        if (map.keySet().contains(root)){
            return map.get(root);
        }
        int res = 0;
        // 偷取这个节点
        if (root.left!=null){
            res += rob(root.left.left);
            res += rob(root.left.right);
        }
        if (root.right!=null){
            res += rob(root.right.left);
            res += rob(root.right.right);
        }
        res += root.val;

        // 不偷取这个节点
        int r2 = 0;
        r2+=rob(root.left);
        r2+=rob(root.right);

        map.put(root,Math.max(res,r2));
        return map.get(root);

    }
}
