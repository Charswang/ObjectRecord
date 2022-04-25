package leetcode.GraphAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2022-4-25
 * 图
 */
public class P310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 邻接表做表
        ArrayList<ArrayList<Integer>> degrees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> degree = new ArrayList<>();
            degrees.add(degree);
        }
        for (int[] edge : edges) {
            ArrayList<Integer> edge0 = degrees.get(edge[0]);
            ArrayList<Integer> edge1 = degrees.get(edge[1]);
            edge0.add(edge[1]);
            edge1.add(edge[0]);
        }

        Queue<Integer> que = new LinkedList<>();
        int temp = 0;
        while (n > 2) {
            // 查找度为1的节点
            for (int i = 0; i < degrees.size(); i++) {
                if (degrees.get(i).size() == 1) {
                    que.add(i);
                }
            }
            // 删除度为1的节点
            while (!que.isEmpty()) {
                final Integer poll = que.poll();
                final ArrayList<Integer> integers = degrees.get(poll);
                temp = integers.get(0);
                integers.remove(0);
                degrees.get(temp).remove(new Integer(poll));
                n--;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(temp);
        }else {
            for (int i = 0; i < degrees.size(); i++) {
                if (degrees.get(i).size() == 1) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
