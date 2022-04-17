package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2022-4-6
 * 每日一题
 * 图
 */
public class P310_Graph_NO {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        List<Integer> minHeightTrees = findMinHeightTrees(n, edges);
        for (Integer minHeightTree : minHeightTrees) {
            System.out.println(minHeightTree);
        }
    }
    // 超出内存限制。。。
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 构建图
        int[] v = new int[n];
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : edges) {
            v[edge[0]]++;
            v[edge[1]]++;
            graph[edge[0]][edge[1]]=true;
            graph[edge[1]][edge[0]]=true;
        }
        // 每次删除度为1的点，直到最后剩下1个或者两个节点，因为大于2个节点时，肯定还会有度大于1的节点
        int[] visited = new int[n];
        Queue<Integer> que = new LinkedList<>();
        while (n>2){
            // 找到度为1的节点

            for (int i = 0;i < v.length;i++){
                if (v[i]==1){
                    que.add(i);
                }
            }
            // 删除度为1的节点
            while (!que.isEmpty()){
                Integer poll = que.poll();
                v[poll]--;
                n--;
                visited[poll]=1;
                for (int i = 0;i < v.length;i++){
                    if (graph[poll][i]){
                        graph[i][poll]=false;
                        graph[poll][i]=false;
                        v[i]--;
                    }
                }
            }
        }
        for (int i : visited) {
            System.out.println(i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i < v.length;i++){
            if (visited[i]==0){
                res.add(i);
            }
            System.out.println(visited[i]+"ff");
        }
        return res;
    }
}
