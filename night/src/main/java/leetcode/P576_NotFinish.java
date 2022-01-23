package leetcode;

public class P576_NotFinish {
    int res = 0;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] visited = new int[m][n];
        dfs(m, n, 0, maxMove, startRow, startColumn, visited);
        return res;
    }

    public void dfs(int m, int n, int moved, int maxMove, int startRow, int startColumn, int[][] visited) {
        if (moved >= maxMove) {
            return;
        }
        if (startColumn == 0 || startColumn == n-1 || startRow == 0 || startRow == m-1) {
            res++;
        }
        visited[startRow][startColumn] = 1;
        int[][] temp = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int row = startRow + temp[i][0];
            int column = startColumn + temp[i][1];
            if (row >= 0 && row < m && column >= 0 && column < n) {
                if (visited[row][column] == 0) {
                    dfs(m, n, moved + 1, maxMove, row, column, visited);
                }
            }else{
                if (moved < maxMove){
                    res++;
                }
            }
        }
        visited[startRow][startColumn] = 0;
    }
}
