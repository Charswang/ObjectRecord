package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2021-12-25
 * 每日一题
 *
 * 图论--拓扑排序
 */
public class P851_UN {
    public static void main(String[] args) {
        int[] quiet = new int[2];
//        int[][] richer = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[][] richer = new int[][]{{0,1},{1,2}};
        loudAndRich(richer,quiet);
    }
    // 拓扑排序+邻接表
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int[][] temp = new int[quiet.length][quiet.length];
        int[] in = new int[quiet.length];
        for (int[] ints : richer) {
            temp[ints[0]][ints[1]] = 1;
            in[ints[1]]++; // 入度+1
        }
        Queue<Integer> que = new LinkedList<>();
        int[] res = new int[quiet.length];
        for (int i = 0;i < res.length;i++){
            res[i] = i;
            if (in[i]==0){
                que.add(i);
            }
        }
        while (!que.isEmpty()){
            Integer poll = que.poll();
            for (int i = 0;i < quiet.length;i++){
                if (temp[poll][i]==1){
                    if (quiet[res[poll]]<quiet[res[i]]){
                        res[i] = res[poll];
                    }
                    if (--in[i]==0){
                        que.add(i);
                    }
                }
            }
        }
        return res;
    }

    /*public int[] loudAndRich2(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[][] w = new int[n][n];
        int[] in = new int[n];
        for (int[] r : richer) {
            int a = r[0], b = r[1];
            w[a][b] = 1; in[b]++;
        }
        Deque<Integer> d = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (in[i] == 0) d.addLast(i);
        }
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int u = 0; u < n; u++) {
                if (w[t][u] == 1) {
                    if (quiet[ans[t]] < quiet[ans[u]]) ans[u] = ans[t];
                    if (--in[u] == 0) d.addLast(u);
                }
            }
        }
        return ans;
    }*/
}
