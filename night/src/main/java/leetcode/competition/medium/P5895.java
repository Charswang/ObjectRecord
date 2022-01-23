package leetcode.competition.medium;

import java.util.Arrays;

public class P5895 {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] put = new int[m*n];
        int res = 0;
        int t = grid[0][0] % x;
        int a = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j<n;j++){
                if (grid[i][j]%x!=t){
                    return -1;
                }
                put[a] = grid[i][j];
                a++;
            }
        }
        Arrays.sort(put);
        int d = put[put.length/2];
        for (int i = 0;i < put.length;i++){
            res+=Math.abs((put[i]-d))/x;
        }
        return res;
    }
}
