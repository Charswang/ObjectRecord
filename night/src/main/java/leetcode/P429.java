package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2022-4-10
 * 2022-4-08的每日一题
 *
 * N叉树的层序遍历
 */
public class P429 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了79.80%的用户
     * 内存消耗：42.4 MB, 在所有 Java 提交中击败了31.91%的用户
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node1 root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node1> q1 = new LinkedList<>();
        q1.add(root);
        List<Integer> list = new ArrayList<>();
        Queue<Node1> q2 = new LinkedList<>();
        while (!q1.isEmpty()){
            Node1 poll = q1.poll();
            list.add(poll.val);
            for (Node1 child : poll.children) {
                q2.add(child);
            }
            if (q1.isEmpty()){
                q1=q2;
                res.add(list);
                list = new ArrayList<>();
                q2 = new LinkedList<>();
            }
        }
        return res;
    }

    /**
     * 超出时间限制， 这个代码有错误，最终修改成上面的代码
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node1 root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node1> q1 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Queue<Node1> q2 = new LinkedList<>();
            Node1 poll = q1.poll();
            list.add(poll.val);
            for (Node1 child : poll.children) { // 这里别再写成root.children了
                q2.add(child);
            }
            if (q1.isEmpty()){
                q1=q2;
                res.add(list);
            }
        }
        return res;
    }
}
class Node1 {
    public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, List<Node1> _children) {
        val = _val;
        children = _children;
    }
};
