package leetcode;

public class P526 {
    static int res = 0;

    public static void main(String[] args) {
        int n = 2;
        if (n < 2) {
            System.out.println(1);
        }
        int[] visited = new int[n + 1];
        dfs(2, visited, n);
        System.out.println(res);
    }

    public static void dfs(int num, int[] visited, int n) {
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == 0) {
                if (i % num == 0 || num % i == 0) {
                    if (num == n) {
                        res++;
                        continue;
                    }
                    visited[i] = 1;
                    dfs(num + 1, visited, n);
                    visited[i] = 0;
                }
            }
        }

    }
}
