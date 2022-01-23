package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P797 {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(0);
        dfs(lists,integers,graph,graph.length-1,0);
        return lists;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> item, int[][] graph, int n, int num) {
        if (num == n) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = 0; i < graph[num].length; i++) {
            item.add(graph[num][i]);
            dfs(res, item, graph, n, graph[num][i]);
            item.remove(item.size() - 1);
        }
        return;
    }
}
