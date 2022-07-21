package leetcode.SwordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-7-21
 */
public class SwordOffer26 {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /*if (B==null){
            return false;
        }
        List<TreeNode> list = new ArrayList<>();
        getANode(list,A,B);
        for (TreeNode treeNode : list) {
            if (check(treeNode,B)){
                return true;
            }
        }
        return false;*/
        return (A!=null && B!=null) && (check(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    public void getANode(List<TreeNode> list, TreeNode A, TreeNode B) {
        if (A == null) {
            return;
        }
        if (A.val == B.val) {
            list.add(A);
        }
        getANode(list,A.left,B);
        getANode(list,A.right,B);
    }
    // 这一块没问题。
    public boolean check(TreeNode A,TreeNode B){
        if (B==null){
            return true;
        }
        if (A!=null && A.val==B.val){
            boolean b1 = check(A.left, B.left);
            boolean b2 = check(A.right, B.right);
            if (b1 && b2){
                return true;
            }
            return false;
        }
        return false;
    }
}
