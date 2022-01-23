package leetcode;

/**
 * 2021-1-1
 * 每日一题
 *
 * 注意不能构成二维数组的情况
 */
public class P2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n<original.length || original.length%(m*n)!=0){
            return new int[0][0];
        }
        int[][] res = new int[m][n];
        int t = 0;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                res[i][j] = original[t++];
            }
        }
        return res;
    }
}
