package leetcode;

/**
 * 2021-10-25
 * 每日一题
 */
public class P240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int row = -1; // 目标值在前row列
        for (int i = 0;i < len2;i++){
            if (matrix[0][i]>target){
                break;
            }
            row++;
        }
        for (int i = 0;i < len1;i++){
            if (matrix[i][0]>target){
                return false;
            }
            for (int j = 0;j <= row;j++){
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
