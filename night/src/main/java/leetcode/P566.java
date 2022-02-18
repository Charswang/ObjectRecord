package leetcode;

/**
 * 2022-2-18
 */
public class P566 {
    public static void main(String[] args) {

    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int a = r*c;
        int b = mat.length * mat[0].length;
        if (a!=b){
            return mat;
        }
        int[][] res = new int[r][c];
        int m = 0;
        int n = 0;
        for (int i = 0;i < mat.length;i++){
            for (int j = 0;j < mat[0].length;j++){
                res[m][n] = mat[i][j];
                if (n+1>=c){
                    m++;
                    n=0;
                }else {
                    n++;
                }
            }
        }
        return res;
    }
}
