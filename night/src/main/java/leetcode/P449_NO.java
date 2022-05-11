package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2022-5-11
 * 每日一题
 *
 * 二叉搜索树的序列化与反序列化
 *
 * 先序进行序列化
 * 根据先序和搜索树特点反序列化
 */
public class P449_NO {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(1);
        ans.add(1);
        System.out.println(ans.toString());
    }

    // Encodes a tree to a single string.
    // 使用先序遍历
    public String serialize(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        String res = ans.toString();
        return res.substring(1, res.length() - 1);
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        // 获得先序排列顺序的数组
        String[] split = data.split(", ");
        return dfs(0,split.length-1,split);
    }

    /**
     * 根据二叉搜索树的先序遍历，重构二叉搜索树
     * @param left
     * @param right
     * @param split
     * @return
     */
    public TreeNode dfs(int left, int right, String[] split) {
        if (left>right){
            return null;
        }
        // 获取当前子树的根节点
        int value = Integer.parseInt(split[left]);
        TreeNode node = new TreeNode(value);
        int l = left + 1;
        int j = l;
        while (j <= right && Integer.parseInt(split[j]) <= value) {
            j++;
        }
        node.left = dfs(l, j - 1, split);
        node.right = dfs(j, right, split);
        return node;
    }
}
