package leetcode;

import java.util.List;

/**
 * 2021-11-21
 * 每日一题
 */
public class P559 {
    public int maxDepth(NodeChildren root) {
        if(root==null){
            return 0;
        }
        List<NodeChildren> childs = root.children;
        int max = 0;
        for(NodeChildren child : childs){
            int a = maxDepth(child);
            max = a > max ? a : max;
        }
        return max+1;
    }
}
class NodeChildren {
    public int val;
    public List<NodeChildren> children;

    public NodeChildren() {}

    public NodeChildren(int _val) {
        val = _val;
    }

    public NodeChildren(int _val, List<NodeChildren> _children) {
        val = _val;
        children = _children;
    }
};
