package leetcode;

import java.util.Arrays;

public class P787_UNFINISH {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println(findCheapestPrice(n, edges, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] f = new int[n];
        /**
         * INF换成Integer.MAX_VALUE就不行了，为什么？？
         */
        int INF = 10000*101+1;
        Arrays.fill(f, INF);
        f[src] = 0;// 将src设为0，是为了从src开始走
        int ans = INF;
        for (int a = 0; a <= k; a++) {
            int[] g = new int[n];
            Arrays.fill(g, INF);
            for (int[] flight : flights) {
                int i = flight[0];
                int j = flight[1];
                int cost = flight[2];
                g[j] = Math.min(g[j],f[i]+cost);
            }
            f = g;
            ans = Math.min(ans,f[dst]);
        }
        return ans==INF?-1:ans;
    }
}
