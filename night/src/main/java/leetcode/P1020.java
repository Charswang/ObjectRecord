package leetcode;

/**
 * 2022-2-12
 * 每日一题 -- dfs
 */
public class P1020 {
    int[][] visited;
    int res = 0;

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && visited[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if (grid[i][m - 1] == 1 && visited[i][m - 1] == 0) {
                dfs(grid, i, m - 1);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (grid[0][i] == 1 && visited[0][i] == 0) {
                dfs(grid, 0, i);
            }
            if (grid[n - 1][i] == 1 && visited[n - 1][i] == 0) {
                dfs(grid, n - 1, i);
            }
        }
        int a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    a++;
                }
            }
        }
        return a - res;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 1 && visited[x][y] == 0) {
            res++;
            visited[x][y] = 1;
            // 上
            if (x - 1 >= 0 && grid[x - 1][y] == 1 && visited[x - 1][y] == 0) {
                dfs(grid, x - 1, y);
            }
            // 下
            if (x + 1 < visited.length && grid[x + 1][y] == 1 && visited[x + 1][y] == 0) {
                dfs(grid, x + 1, y);
            }
            // 左
            if (y - 1 >= 0 && grid[x][y - 1] == 1 && visited[x][y - 1] == 0) {
                dfs(grid, x, y - 1);
            }
            // 右
            if (y + 1 < visited[0].length && grid[x][y + 1] == 1 && visited[x][y + 1] == 0) {
                dfs(grid, x, y + 1);
            }
        }
        return;
    }
}
