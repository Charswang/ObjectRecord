package leetcode;

/**
 * 2022-4-23
 */
public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int len2 = matrix[0].length;

        for (int i = 0; i < len; i++) {
            if (matrix[i][len2 - 1] >= target) {
                for (int j = 0; j < len2; j++) {
                    if (matrix[i][j]==target){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
