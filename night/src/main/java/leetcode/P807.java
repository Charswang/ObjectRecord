package leetcode;

/**
 * 2021-12-13
 * 每日一题
 *
 * 问题不难，难在没理解题目意思--天际线。。。。
 */
public class P807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for (int i = 0;i < rowMax.length;i++){
            for (int j = 0;j < colMax.length;j++){
                rowMax[i] = Math.max(rowMax[i],grid[i][j]);
                colMax[j] = Math.max(colMax[j],grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0;i < rowMax.length;i++){
            for (int j = 0;j < colMax.length;j++){
                res += Math.min(rowMax[i],colMax[j])-grid[i][j];
            }
        }
        return res;
    }
}
