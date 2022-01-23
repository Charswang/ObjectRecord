package leetcode;

/**
 * 2021-9-4
 */
public class P63 {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,1},{0,0}};
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1){
            return 0;
        }else {
            obstacleGrid[0][0]=1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = -1;
            }else{
                obstacleGrid[i][0] = obstacleGrid[i - 1][0] == -1 ? 0 : obstacleGrid[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = -1;
            }else{
                obstacleGrid[0][i] = obstacleGrid[0][i - 1] == -1 ? 0 : obstacleGrid[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                int a = obstacleGrid[i][j - 1] == -1 ? 0 : obstacleGrid[i][j - 1];
                int b = obstacleGrid[i - 1][j] == -1 ? 0 : obstacleGrid[i - 1][j];
                obstacleGrid[i][j] = a + b;
            }
        }
        return obstacleGrid[m - 1][n - 1]==-1?0:obstacleGrid[m-1][n-1];
    }
}
